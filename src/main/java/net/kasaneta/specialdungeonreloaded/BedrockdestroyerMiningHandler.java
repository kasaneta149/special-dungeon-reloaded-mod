package net.kasaneta.specialdungeonreloaded.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.item.BedrockdestroyerItem;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber
public class BedrockdestroyerMiningHandler {
	public static final int BREAK_TICKS = 80;
	private static final double MAX_DISTANCE_SQR = 36;

	private static final class Mining {
		private final BlockPos pos;
		private final long startTick;
		private int lastStage = -1;

		private Mining(BlockPos pos, long startTick) {
			this.pos = pos;
			this.startTick = startTick;
		}
	}

	private static final Map<UUID, Mining> MINING = new HashMap<>();

	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		if (event.getAction() == PlayerInteractEvent.LeftClickBlock.Action.START)
			start(player, event.getPos());
		else
			stop(player);
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		if (MINING.isEmpty() || !(event.getEntity() instanceof ServerPlayer player))
			return;
		Mining mining = MINING.get(player.getUUID());
		if (mining == null)
			return;
		ServerLevel level = player.serverLevel();
		if (!player.isAlive() || !(player.getMainHandItem().getItem() instanceof BedrockdestroyerItem) || !level.getBlockState(mining.pos).is(Blocks.BEDROCK) || player.distanceToSqr(Vec3.atCenterOf(mining.pos)) > MAX_DISTANCE_SQR) {
			stop(player);
			return;
		}
		int elapsed = (int) (level.getGameTime() - mining.startTick);
		if (elapsed >= BREAK_TICKS) {
			finish(player, level, mining);
			return;
		}
		int stage = elapsed * 10 / BREAK_TICKS;
		if (stage != mining.lastStage) {
			mining.lastStage = stage;
			level.destroyBlockProgress(player.getId(), mining.pos, stage);
		}
	}

	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		MINING.remove(event.getEntity().getUUID());
	}

	@SubscribeEvent
	public static void onServerStopped(ServerStoppedEvent event) {
		MINING.clear();
	}

	private static void start(ServerPlayer player, BlockPos pos) {
		ServerLevel level = player.serverLevel();
		if (player.isCreative() || !(player.getMainHandItem().getItem() instanceof BedrockdestroyerItem) || !level.getBlockState(pos).is(Blocks.BEDROCK) || !level.mayInteract(player, pos)) {
			stop(player);
			return;
		}
		MINING.put(player.getUUID(), new Mining(pos.immutable(), level.getGameTime()));
	}

	private static void stop(ServerPlayer player) {
		Mining mining = MINING.remove(player.getUUID());
		if (mining != null)
			player.serverLevel().destroyBlockProgress(player.getId(), mining.pos, -1);
	}

	private static void finish(ServerPlayer player, ServerLevel level, Mining mining) {
		MINING.remove(player.getUUID());
		level.destroyBlockProgress(player.getId(), mining.pos, -1);
		BlockState state = level.getBlockState(mining.pos);
		if (player.gameMode.destroyBlock(mining.pos)) {
			player.connection.send(new ClientboundLevelEventPacket(2001, mining.pos, Block.getId(state), false));
			Block.popResource(level, mining.pos, new ItemStack(Items.BEDROCK));
		}
	}
}