package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.LiquibonesMobplayerCollidesBlockProcedure;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModFluids;

public class LiquibonesBlock extends LiquidBlock {
	public LiquibonesBlock() {
		super(SpecialDungeonReloadedModFluids.LIQUIBONES.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LiquibonesMobplayerCollidesBlockProcedure.execute(world, entity);
	}
}