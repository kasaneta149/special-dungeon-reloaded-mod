package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.BlockPos;

import java.util.Optional;

public class OverworldExit {
	private record Spawn(Vec3 position, float yaw) {
	}

	public static void send(ServerPlayer player) {
		if (player.level().dimension().equals(Level.OVERWORLD))
			return;
		ServerLevel overworld = player.server.getLevel(Level.OVERWORLD);
		if (overworld == null || !player.canChangeDimensions(player.level(), overworld))
			return;
		Spawn spawn = findSpawn(player, overworld);
		player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
		player.teleportTo(overworld, spawn.position().x, spawn.position().y, spawn.position().z, spawn.yaw(), player.getXRot());
		player.resetFallDistance();
		player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
		for (MobEffectInstance effect : player.getActiveEffects())
			player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effect, false));
		player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
	}

	private static Spawn findSpawn(ServerPlayer player, ServerLevel overworld) {
		BlockPos respawn = player.getRespawnPosition();
		if (respawn != null && player.getRespawnDimension().equals(Level.OVERWORLD)) {
			if (player.isRespawnForced())
				return new Spawn(Vec3.atBottomCenterOf(respawn), player.getRespawnAngle());
			BlockState state = overworld.getBlockState(respawn);
			if (state.getBlock() instanceof BedBlock) {
				Optional<Vec3> standUp = BedBlock.findStandUpPosition(EntityType.PLAYER, overworld, respawn, state.getValue(BedBlock.FACING), player.getRespawnAngle());
				if (standUp.isPresent())
					return new Spawn(standUp.get(), player.getRespawnAngle());
			}
		}
		BlockPos worldSpawn = overworld.getSharedSpawnPos();
		int surface = overworld.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, worldSpawn.getX(), worldSpawn.getZ());
		return new Spawn(new Vec3(worldSpawn.getX() + 0.5, surface, worldSpawn.getZ() + 0.5), overworld.getSharedSpawnAngle());
	}
}