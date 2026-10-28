package net.kasaneta.specialdungeonreloaded.procedures;

import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.kasaneta.specialdungeonreloaded.item.BedrockdestroyerItem;

@EventBusSubscriber(value = Dist.CLIENT)
public class BedrockdestroyerCracksClient {
	private static final int OVERLAY_ID = -4242;
	private static BlockPos current = null;
	private static int ticks = 0;

	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post event) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer player = minecraft.player;
		ClientLevel level = minecraft.level;
		if (player == null || level == null) {
			current = null;
			ticks = 0;
			return;
		}
		BlockPos target = findTarget(minecraft, player, level);
		if (target == null) {
			clear(level);
			return;
		}
		if (!target.equals(current)) {
			clear(level);
			current = target;
		}
		ticks++;
		level.destroyBlockProgress(OVERLAY_ID, current, Math.min(9, ticks * 10 / BedrockdestroyerMiningHandler.BREAK_TICKS - 1));
	}

	private static BlockPos findTarget(Minecraft minecraft, LocalPlayer player, ClientLevel level) {
		if (minecraft.screen != null || !minecraft.options.keyAttack.isDown() || player.isCreative() || !(player.getMainHandItem().getItem() instanceof BedrockdestroyerItem))
			return null;
		if (!(minecraft.hitResult instanceof BlockHitResult hit) || hit.getType() != HitResult.Type.BLOCK)
			return null;
		BlockPos pos = hit.getBlockPos();
		return level.getBlockState(pos).is(Blocks.BEDROCK) ? pos : null;
	}

	private static void clear(ClientLevel level) {
		if (current != null)
			level.destroyBlockProgress(OVERLAY_ID, current, -1);
		current = null;
		ticks = 0;
	}
}