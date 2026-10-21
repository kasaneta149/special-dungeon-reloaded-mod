package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.UnnaturalbrickEntityWalksOnTheBlockProcedure;

public class PortaltodungeonscraftableBlock extends Block {
	public PortaltodungeonscraftableBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SCULK).strength(2f).noCollission());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		UnnaturalbrickEntityWalksOnTheBlockProcedure.execute(entity);
	}
}