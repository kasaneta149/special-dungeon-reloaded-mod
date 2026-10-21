package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class LsredgrassBlock extends Block {
	public LsredgrassBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(0.6f, 0f));
	}
}