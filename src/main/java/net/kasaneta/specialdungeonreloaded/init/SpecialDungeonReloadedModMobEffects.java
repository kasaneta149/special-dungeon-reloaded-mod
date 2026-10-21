/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.kasaneta.specialdungeonreloaded.potion.NotcarrefulMobEffect;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class SpecialDungeonReloadedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, SpecialDungeonReloadedMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> NOTCARREFUL = REGISTRY.register("notcarreful", NotcarrefulMobEffect::new);
}