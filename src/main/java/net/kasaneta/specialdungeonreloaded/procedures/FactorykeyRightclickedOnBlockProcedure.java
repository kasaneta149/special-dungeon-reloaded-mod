package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class FactorykeyRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		if (blockstate.getBlock() == SpecialDungeonReloadedModBlocks.FACTORYDOOR.get()) {
			DoorUnlock.openNamed(world, x, y, z, "dungeons.doors.factory", DoorUnlock.DARK_BLUE, DoorUnlock.GRAY, 1);
			itemstack.shrink(1);
		}
	}
}