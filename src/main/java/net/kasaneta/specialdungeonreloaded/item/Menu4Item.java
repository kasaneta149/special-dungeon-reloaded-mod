package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class Menu4Item extends Item {
	public Menu4Item() {
		super(new Item.Properties().stacksTo(1).food((new FoodProperties.Builder()).nutrition(8).saturationModifier(2.5f).alwaysEdible().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 70;
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}