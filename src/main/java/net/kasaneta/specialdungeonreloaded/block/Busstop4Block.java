package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class Busstop4Block extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public Busstop4Block() {
		super(BlockBehaviour.Properties.of().strength(5f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(8, -16, 14, 12, 32, 16), box(9.3, 5, 5, 10.7, 19, 14), box(9.3, 24, 0, 10.7, 29, 14), box(9, 23.5, -0.5, 11, 24, 14), box(9, 29, -0.5, 11, 29.5, 14), box(9, 24, -0.5, 11, 29, 0), box(9, 5, 4.5, 11, 19, 5),
						box(9, 19, 4.5, 11, 19.5, 14), box(9, 4.5, 4.5, 11, 5, 14));
				case EAST -> Shapes.or(box(0, -16, 8, 2, 32, 12), box(2, 5, 9.3, 11, 19, 10.7), box(2, 24, 9.3, 16, 29, 10.7), box(2, 23.5, 9, 16.5, 24, 11), box(2, 29, 9, 16.5, 29.5, 11), box(16, 24, 9, 16.5, 29, 11), box(11, 5, 9, 11.5, 19, 11),
						box(2, 19, 9, 11.5, 19.5, 11), box(2, 4.5, 9, 11.5, 5, 11));
				case WEST -> Shapes.or(box(14, -16, 4, 16, 32, 8), box(5, 5, 5.3, 14, 19, 6.7), box(0, 24, 5.3, 14, 29, 6.7), box(-0.5, 23.5, 5, 14, 24, 7), box(-0.5, 29, 5, 14, 29.5, 7), box(-0.5, 24, 5, 0, 29, 7), box(4.5, 5, 5, 5, 19, 7),
						box(4.5, 19, 5, 14, 19.5, 7), box(4.5, 4.5, 5, 14, 5, 7));
				case UP -> Shapes.or(box(8, 0, -16, 12, 2, 32), box(9.3, 2, 5, 10.7, 11, 19), box(9.3, 2, 24, 10.7, 16, 29), box(9, 2, 23.5, 11, 16.5, 24), box(9, 2, 29, 11, 16.5, 29.5), box(9, 16, 24, 11, 16.5, 29), box(9, 11, 5, 11, 11.5, 19),
						box(9, 2, 19, 11, 11.5, 19.5), box(9, 2, 4.5, 11, 11.5, 5));
				case DOWN -> Shapes.or(box(8, 14, -16, 12, 16, 32), box(9.3, 5, -3, 10.7, 14, 11), box(9.3, 0, -13, 10.7, 14, -8), box(9, -0.5, -8, 11, 14, -7.5), box(9, -0.5, -13.5, 11, 14, -13), box(9, -0.5, -13, 11, 0, -8),
						box(9, 4.5, -3, 11, 5, 11), box(9, 4.5, -3.5, 11, 14, -3), box(9, 4.5, 11, 11, 14, 11.5));
				default -> Shapes.or(box(4, -16, 0, 8, 32, 2), box(5.3, 5, 2, 6.7, 19, 11), box(5.3, 24, 2, 6.7, 29, 16), box(5, 23.5, 2, 7, 24, 16.5), box(5, 29, 2, 7, 29.5, 16.5), box(5, 24, 16, 7, 29, 16.5), box(5, 5, 11, 7, 19, 11.5),
						box(5, 19, 2, 7, 19.5, 11.5), box(5, 4.5, 2, 7, 5, 11.5));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getClickedFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}