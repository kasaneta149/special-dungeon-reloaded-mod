package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class LspoolblockBlock extends Block {
	public LspoolblockBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}