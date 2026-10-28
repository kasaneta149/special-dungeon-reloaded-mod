package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class OpenPurpleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		if (blockstate.getBlock() == SpecialDungeonReloadedModBlocks.PURPLEDOOR.get()) {
			DoorUnlock.open(world, x, y, z, blockstate, DoorUnlock.DARK_BLUE, DoorUnlock.PURPLE, 1);
			itemstack.shrink(1);
		}
	}
}