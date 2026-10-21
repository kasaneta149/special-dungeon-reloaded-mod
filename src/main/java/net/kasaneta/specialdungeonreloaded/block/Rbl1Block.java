package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluids;

public class Rbl1Block extends LiquidBlock {
	public Rbl1Block() {
		super(SpecialDungeonReloadedModFluids.RBL_1.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(0f).lightLevel(state -> 3).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 2;
	}
}