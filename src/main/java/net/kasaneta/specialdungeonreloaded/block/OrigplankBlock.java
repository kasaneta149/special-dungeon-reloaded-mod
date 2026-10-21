package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class OrigplankBlock extends Block {
	public OrigplankBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f, 10f));
	}
}