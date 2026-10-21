package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.kasaneta.specialdungeonreloaded.procedures.Busshedule9RightclickedProcedure;

public class Busshedule3Item extends Item {
	public Busshedule3Item() {
		super(new Item.Properties().durability(200));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Busshedule9RightclickedProcedure.execute(ar.getObject());
		return ar;
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}