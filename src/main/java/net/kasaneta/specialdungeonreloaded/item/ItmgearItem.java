package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class ItmgearItem extends Item {
	public ItmgearItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON));
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}