package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class RbstarsBlock extends Block {
	public RbstarsBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(blockstate -> 15));
	}
}