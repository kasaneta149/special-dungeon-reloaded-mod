package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.UnnaturalbrickEntityWalksOnTheBlockProcedure;

public class UnnaturalbrickBlock extends Block {
	private static final VoxelShape SHAPE = box(0.5, -1, 0, 16.5, 15, 16);

	public UnnaturalbrickBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SCULK).instabreak().noCollission().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		UnnaturalbrickEntityWalksOnTheBlockProcedure.execute(entity);
	}
}