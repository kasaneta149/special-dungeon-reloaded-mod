package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.kasaneta.specialdungeonreloaded.entity.FinalbossEntity;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class BossbulletProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof FinalbossEntity)) {
			if (Mth.nextInt(RandomSource.create(), 1, 20) == 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 1200, 5, false, false));
			} else if (Mth.nextInt(RandomSource.create(), 1, 55) == 10) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("special_dungeon_reloaded:lafa"), (-14), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 1, false, false));
				SpecialDungeonReloadedMod.queueServerWork(600, () -> {
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MAX_HEALTH).removeModifier(ResourceLocation.parse("special_dungeon_reloaded:lafa"));
					}
				});
			} else if (Mth.nextInt(RandomSource.create(), 1, 100) == 5) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2"), (-18), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2arm"), (-40), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2jsp"), (-0.2), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 1, false, false));
				SpecialDungeonReloadedMod.queueServerWork(300, () -> {
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MAX_HEALTH).removeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2arm"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("special_dungeon_reloaded:bad2jsp"));
					}
				});
			}
		}
	}
}