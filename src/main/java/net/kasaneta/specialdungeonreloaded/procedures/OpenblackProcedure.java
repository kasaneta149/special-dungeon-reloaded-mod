package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class OpenblackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == SpecialDungeonReloadedModBlocks.BLACKDOOR.get()) {
			if (entity instanceof LivingEntity living && !living.level().isClientSide()) {
				living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, false, false));
				living.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1, false, false));
				living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 3, false, false));
			}
			DoorUnlock.open(world, x, y, z, blockstate, DoorUnlock.BLACK, DoorUnlock.LIME, 0.5f);
			itemstack.shrink(1);
		}
	}
}