package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class DarksonelsBlock extends Block {
	public DarksonelsBlock() {
		super(BlockBehaviour.Properties.of().strength(0.05f, 0f).requiresCorrectToolForDrops());
	}
}