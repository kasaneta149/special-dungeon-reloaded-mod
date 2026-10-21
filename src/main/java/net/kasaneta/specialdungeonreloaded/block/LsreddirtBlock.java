package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class LsreddirtBlock extends Block {
	public LsreddirtBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(0.5f, 0f));
	}
}