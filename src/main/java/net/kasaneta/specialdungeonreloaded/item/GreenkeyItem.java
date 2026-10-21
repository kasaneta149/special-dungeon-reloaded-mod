package net.kasaneta.specialdungeonreloaded.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.kasaneta.specialdungeonreloaded.procedures.OpengreenProcedure;

public class GreenkeyItem extends Item {
	public GreenkeyItem() {
		super(new Item.Properties().durability(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		OpengreenProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}