package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.item.ItemStack;

public class Busshedule9RightclickedProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getDamageValue() == 199) {
			itemstack.setDamageValue(0);
		} else {
			itemstack.setDamageValue(199);
		}
	}
}