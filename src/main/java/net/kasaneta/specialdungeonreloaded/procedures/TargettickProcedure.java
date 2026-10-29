package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class TargettickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || !(world instanceof ServerLevel level) || entity.tickCount % 20 != 0)
			return;
		BlockPos pos = BlockPos.containing(x, y - 1, z);
		if (level.getBlockState(pos).getBlock() == SpecialDungeonReloadedModBlocks.LASERGAMETARGETMAKER.get())
			LaserGame.setBoundTarget(level, pos, entity.getStringUUID());
	}
}