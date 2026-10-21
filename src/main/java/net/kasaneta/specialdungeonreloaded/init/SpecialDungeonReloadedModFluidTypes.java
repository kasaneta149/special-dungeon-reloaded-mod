/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.kasaneta.specialdungeonreloaded.fluid.types.Rbl1FluidType;
import net.kasaneta.specialdungeonreloaded.fluid.types.LiquibonesFluidType;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class SpecialDungeonReloadedModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, SpecialDungeonReloadedMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> RBL_1_TYPE = REGISTRY.register("rbl_1", Rbl1FluidType::new);
	public static final DeferredHolder<FluidType, FluidType> LIQUIBONES_TYPE = REGISTRY.register("liquibones", LiquibonesFluidType::new);
}