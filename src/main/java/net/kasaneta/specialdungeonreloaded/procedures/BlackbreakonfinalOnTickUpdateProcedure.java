package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class BlackbreakonfinalOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).final_dead) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}