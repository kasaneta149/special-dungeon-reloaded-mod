package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class LasergamecontrollerNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof ServerLevel level))
			return;
		BlockPos pos = BlockPos.containing(x, y, z);
		if (LaserGame.isStarted(level, pos)) {
			LaserGame.setStarted(level, pos, false);
			LaserGame.finish(level);
		} else {
			LaserGame.setStarted(level, pos, true);
			LaserGame.start(level, pos);
		}
	}
}