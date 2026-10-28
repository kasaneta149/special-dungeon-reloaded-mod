package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class RainbowkeyRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		Block block = blockstate.getBlock();
		int nameColor;
		int unlockedColor = DoorUnlock.GREEN;
		if (block == SpecialDungeonReloadedModBlocks.BLUEDOOR.get())
			nameColor = DoorUnlock.DARK_BLUE;
		else if (block == SpecialDungeonReloadedModBlocks.RED_DOOR.get())
			nameColor = DoorUnlock.RED;
		else if (block == SpecialDungeonReloadedModBlocks.GREENDOOR.get())
			nameColor = DoorUnlock.GREEN;
		else if (block == SpecialDungeonReloadedModBlocks.YELLOWDOOR.get())
			nameColor = DoorUnlock.YELLOW;
		else if (block == SpecialDungeonReloadedModBlocks.CYANDOOR.get())
			nameColor = DoorUnlock.AQUA;
		else if (block == SpecialDungeonReloadedModBlocks.ORANGEDOOR.get())
			nameColor = DoorUnlock.GOLD;
		else if (block == SpecialDungeonReloadedModBlocks.BROWNDOOR.get())
			nameColor = DoorUnlock.BROWN;
		else if (block == SpecialDungeonReloadedModBlocks.PURPLEDOOR.get()) {
			nameColor = DoorUnlock.DARK_BLUE;
			unlockedColor = DoorUnlock.PURPLE;
		} else
			return;
		DoorUnlock.open(world, x, y, z, blockstate, nameColor, unlockedColor, 1);
		itemstack.shrink(1);
	}
}