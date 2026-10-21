package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DimentionnalslabBlock extends Block {
	public DimentionnalslabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHER_BRICKS).strength(0.4f, 5f).requiresCorrectToolForDrops());
	}
}