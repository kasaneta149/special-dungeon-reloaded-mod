package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class OpenwhiteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == SpecialDungeonReloadedModBlocks.WHITEDOOR.get()) {
			if (entity instanceof LivingEntity living && !living.level().isClientSide()) {
				living.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 120, 1, false, false));
				living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 120, 1, false, false));
			}
			DoorUnlock.open(world, x, y, z, blockstate, DoorUnlock.WHITE, DoorUnlock.GREEN, 0.75f);
			itemstack.shrink(1);
		}
	}
}