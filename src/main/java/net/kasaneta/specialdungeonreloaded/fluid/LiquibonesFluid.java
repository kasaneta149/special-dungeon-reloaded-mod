package net.kasaneta.specialdungeonreloaded.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModItems;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluids;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluidTypes;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public abstract class LiquibonesFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> SpecialDungeonReloadedModFluidTypes.LIQUIBONES_TYPE.get(), () -> SpecialDungeonReloadedModFluids.LIQUIBONES.get(),
			() -> SpecialDungeonReloadedModFluids.FLOWING_LIQUIBONES.get()).explosionResistance(100f).bucket(() -> SpecialDungeonReloadedModItems.LIQUIBONES_BUCKET.get()).block(() -> (LiquidBlock) SpecialDungeonReloadedModBlocks.LIQUIBONES.get());

	private LiquibonesFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquibonesFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquibonesFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}