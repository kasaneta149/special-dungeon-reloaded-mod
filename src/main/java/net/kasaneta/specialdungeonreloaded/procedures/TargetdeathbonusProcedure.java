package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class TargetdeathbonusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity instanceof ServerPlayer player)
			LaserGame.reward(player, 3, "game.targethit2");
		if (!(world instanceof ServerLevel level))
			return;
		BlockPos pos = BlockPos.containing(x, y - 1, z);
		if (level.getBlockState(pos).getBlock() == SpecialDungeonReloadedModBlocks.LASERGAMETARGETMAKER.get())
			LaserGame.setBoundTarget(level, pos, "");
	}
}