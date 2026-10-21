package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class Ps3wcontrollerItem extends Item {
	public Ps3wcontrollerItem() {
		super(new Item.Properties());
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}