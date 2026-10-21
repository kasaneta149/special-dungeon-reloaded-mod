package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class DungeonstairsupBlock extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public DungeonstairsupBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(blockstate -> 2).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 0, 0, 16, 4, 4), box(0, 0, 4, 16, 8, 8), box(0, 0, 8, 16, 12, 12), box(0, 0, 12, 16, 16, 16));
				case EAST -> Shapes.or(box(12, 0, 0, 16, 4, 16), box(8, 0, 0, 12, 8, 16), box(4, 0, 0, 8, 12, 16), box(0, 0, 0, 4, 16, 16));
				case WEST -> Shapes.or(box(0, 0, 0, 4, 4, 16), box(4, 0, 0, 8, 8, 16), box(8, 0, 0, 12, 12, 16), box(12, 0, 0, 16, 16, 16));
				case UP -> Shapes.or(box(0, 12, 0, 16, 16, 4), box(0, 8, 0, 16, 12, 8), box(0, 4, 0, 16, 8, 12), box(0, 0, 0, 16, 4, 16));
				case DOWN -> Shapes.or(box(0, 0, 12, 16, 4, 16), box(0, 4, 8, 16, 8, 16), box(0, 8, 4, 16, 12, 16), box(0, 12, 0, 16, 16, 16));
				default -> Shapes.or(box(0, 0, 12, 16, 4, 16), box(0, 0, 8, 16, 8, 12), box(0, 0, 4, 16, 12, 8), box(0, 0, 0, 16, 16, 4));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
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
		return state.setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}