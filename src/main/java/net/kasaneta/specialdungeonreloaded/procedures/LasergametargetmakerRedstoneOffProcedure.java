package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class LasergametargetmakerRedstoneOffProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof ServerLevel level))
			return;
		Entity target = LaserGame.getBoundTarget(level, BlockPos.containing(x, y, z));
		if (target != null)
			target.discard();
	}
}