package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.TransfertobuildingProcedure;

public class PortaltobuildingBlock extends Block {
	public static final BooleanProperty CANUSE = BooleanProperty.create("canuse");

	public PortaltobuildingBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000).lightLevel(blockstate -> 15).noCollission().instrument(NoteBlockInstrument.BASEDRUM));
		this.registerDefaultState(this.stateDefinition.any().setValue(CANUSE, true));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(CANUSE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(CANUSE, true);
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		TransfertobuildingProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
	}
}