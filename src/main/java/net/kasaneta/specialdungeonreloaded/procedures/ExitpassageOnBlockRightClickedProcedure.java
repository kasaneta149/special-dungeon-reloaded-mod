package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ExitpassageOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || !(world instanceof ServerLevel level))
			return;
		level.playSound(null, BlockPos.containing(x, y, z), SoundEvents.WOODEN_DOOR_OPEN, SoundSource.NEUTRAL, 1, 1);
		if (entity instanceof ServerPlayer player)
			OverworldExit.send(player);
	}
}