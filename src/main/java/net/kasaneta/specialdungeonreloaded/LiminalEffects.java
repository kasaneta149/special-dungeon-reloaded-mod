package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;

public class LiminalEffects {
	private static final ResourceKey<DamageType> VOID_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, id("voiddamage"));
	private static final SoundEvent SCREAM_LONG = SoundEvent.createVariableRangeEvent(id("scramer_long"));
	private static final SoundEvent SCREAM_SHORT = SoundEvent.createVariableRangeEvent(id("screamer1s"));

	private static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(LiminalLevel.NAMESPACE, path);
	}

	public static void madness(ServerLevel level, LivingEntity entity) {
		RandomSource random = level.getRandom();
		if (random.nextInt(251) != 5)
			return;
		double roll = random.nextDouble();
		if (roll >= 0.9) {
			addEffect(entity, MobEffects.DARKNESS, 200, 1);
			addEffect(entity, MobEffects.BLINDNESS, 200, 1);
			voidDamage(level, entity, 6 + random.nextInt(12));
			if (random.nextBoolean()) {
				addEffect(entity, SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 45, 1);
				playSound(level, entity, SCREAM_LONG);
			} else {
				addEffect(entity, SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 20, 1);
				playSound(level, entity, SCREAM_SHORT);
			}
		} else if (roll >= 0.7) {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			addEffect(entity, MobEffects.DARKNESS, 200, 1);
			addEffect(entity, MobEffects.BLINDNESS, 200, 1);
		} else if (roll >= 0.58) {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			voidDamage(level, entity, 1 + random.nextInt(5));
			addEffect(entity, MobEffects.CONFUSION, 200, 1);
		} else {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			addEffect(entity, MobEffects.CONFUSION, 200, 1);
		}
	}

	private static void playSound(ServerLevel level, Entity entity, SoundEvent sound) {
		if (!(entity instanceof ServerPlayer player))
			return;
		player.connection.send(new ClientboundSoundPacket(Holder.direct(sound), SoundSource.NEUTRAL, player.getX(), player.getY(), player.getZ(), 1, 1, level.getRandom().nextLong()));
	}

	private static void addEffect(LivingEntity entity, Holder<MobEffect> effect, int duration, int amplifier) {
		entity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false));
	}

	private static void voidDamage(ServerLevel level, LivingEntity entity, float amount) {
		entity.hurt(new DamageSource(level.holderOrThrow(VOID_DAMAGE)), amount);
	}
}