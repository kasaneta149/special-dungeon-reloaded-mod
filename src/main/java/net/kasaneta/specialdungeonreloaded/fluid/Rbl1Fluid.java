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

public abstract class Rbl1Fluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> SpecialDungeonReloadedModFluidTypes.RBL_1_TYPE.get(), () -> SpecialDungeonReloadedModFluids.RBL_1.get(),
			() -> SpecialDungeonReloadedModFluids.FLOWING_RBL_1.get()).explosionResistance(0f).bucket(() -> SpecialDungeonReloadedModItems.RBL_1_BUCKET.get()).block(() -> (LiquidBlock) SpecialDungeonReloadedModBlocks.RBL_1.get());

	private Rbl1Fluid() {
		super(PROPERTIES);
	}

	public static class Source extends Rbl1Fluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends Rbl1Fluid {
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