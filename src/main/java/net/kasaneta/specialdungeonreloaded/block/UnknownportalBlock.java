package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.UnknownportalEntityCollidesInTheBlockProcedure;

public class UnknownportalBlock extends Block {
	public UnknownportalBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SCULK).strength(0.25f, 0f).lightLevel(blockstate -> 5).noCollission().pushReaction(PushReaction.BLOCK));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		UnknownportalEntityCollidesInTheBlockProcedure.execute(entity);
	}
}