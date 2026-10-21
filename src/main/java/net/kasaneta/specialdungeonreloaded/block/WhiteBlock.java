package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class WhiteBlock extends Block {
	public WhiteBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000).lightLevel(blockstate -> 15).instrument(NoteBlockInstrument.BASEDRUM));
	}
}