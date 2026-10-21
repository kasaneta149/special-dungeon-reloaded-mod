/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.kasaneta.specialdungeonreloaded.fluid.Rbl1Fluid;
import net.kasaneta.specialdungeonreloaded.fluid.LiquibonesFluid;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class SpecialDungeonReloadedModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, SpecialDungeonReloadedMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> RBL_1 = REGISTRY.register("rbl_1", Rbl1Fluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RBL_1 = REGISTRY.register("flowing_rbl_1", Rbl1Fluid.Flowing::new);
	public static final DeferredHolder<Fluid, FlowingFluid> LIQUIBONES = REGISTRY.register("liquibones", LiquibonesFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUIBONES = REGISTRY.register("flowing_liquibones", LiquibonesFluid.Flowing::new);

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(RBL_1.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_RBL_1.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LIQUIBONES.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUIBONES.get(), RenderType.translucent());
		}
	}
}