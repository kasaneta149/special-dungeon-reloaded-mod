package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.WaterblockportalEntityCollidesInTheBlockProcedure;

public class WaterblockportalBlock extends Block {
	public WaterblockportalBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(blockstate -> 15).noCollission().friction(0.85f));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		WaterblockportalEntityCollidesInTheBlockProcedure.execute(entity);
	}
}