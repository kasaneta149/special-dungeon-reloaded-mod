package net.kasaneta.specialdungeonreloaded.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

@EventBusSubscriber
public class NotcarrefulMobEffect extends MobEffect {
	public NotcarrefulMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(SpecialDungeonReloadedMod.MODID, "effect.notcarreful_0"), -3.9, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(SpecialDungeonReloadedMod.MODID, "effect.notcarreful_1"), -0.2, AttributeModifier.Operation.ADD_VALUE);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, SpecialDungeonReloadedModMobEffects.NOTCARREFUL.get());
	}
}