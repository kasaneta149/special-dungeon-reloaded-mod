package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class Dhd3OnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).h3_destroyed) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}