package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class GraywallBlock extends Block {
	public GraywallBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000).instrument(NoteBlockInstrument.BASEDRUM));
	}
}