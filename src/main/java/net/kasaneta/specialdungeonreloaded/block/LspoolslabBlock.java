package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class LspoolslabBlock extends SlabBlock {
	public LspoolslabBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000));
	}
}