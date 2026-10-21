package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class Bones826Block extends Block {
	public Bones826Block() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BONE_BLOCK).strength(0.15f, 0f));
	}
}