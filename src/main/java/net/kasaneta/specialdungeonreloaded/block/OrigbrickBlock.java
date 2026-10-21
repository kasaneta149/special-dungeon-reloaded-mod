package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class OrigbrickBlock extends Block {
	public OrigbrickBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(4f, 10f));
	}
}