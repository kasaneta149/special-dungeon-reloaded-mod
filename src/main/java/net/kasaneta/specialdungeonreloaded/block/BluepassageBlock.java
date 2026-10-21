package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.BluepassageOnBlockRightclickedProcedure;

import com.google.common.collect.ImmutableMap;

public class BluepassageBlock extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public BluepassageBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(1, 0, 14, 3, 26, 16), box(13, 0, 14, 15, 26, 16), box(3, 24, 14, 13, 26, 16), box(3, 0, 15, 13, 24, 16), box(4, 13, 13, 7, 14, 14), box(4, 13, 14, 5, 14, 15));
				case EAST -> Shapes.or(box(0, 0, 1, 2, 26, 3), box(0, 0, 13, 2, 26, 15), box(0, 24, 3, 2, 26, 13), box(0, 0, 3, 1, 24, 13), box(2, 13, 4, 3, 14, 7), box(1, 13, 4, 2, 14, 5));
				case WEST -> Shapes.or(box(14, 0, 13, 16, 26, 15), box(14, 0, 1, 16, 26, 3), box(14, 24, 3, 16, 26, 13), box(15, 0, 3, 16, 24, 13), box(13, 13, 9, 14, 14, 12), box(14, 13, 11, 15, 14, 12));
				case UP -> Shapes.or(box(1, 0, 0, 3, 2, 26), box(13, 0, 0, 15, 2, 26), box(3, 0, 24, 13, 2, 26), box(3, 0, 0, 13, 1, 24), box(4, 2, 13, 7, 3, 14), box(4, 1, 13, 5, 2, 14));
				case DOWN -> Shapes.or(box(1, 14, -10, 3, 16, 16), box(13, 14, -10, 15, 16, 16), box(3, 14, -10, 13, 16, -8), box(3, 15, -8, 13, 16, 16), box(4, 13, 2, 7, 14, 3), box(4, 14, 2, 5, 15, 3));
				default -> Shapes.or(box(13, 0, 0, 15, 26, 2), box(1, 0, 0, 3, 26, 2), box(3, 24, 0, 13, 26, 2), box(3, 0, 0, 13, 24, 1), box(9, 13, 2, 12, 14, 3), box(11, 13, 1, 12, 14, 2));
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

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		BluepassageOnBlockRightclickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}