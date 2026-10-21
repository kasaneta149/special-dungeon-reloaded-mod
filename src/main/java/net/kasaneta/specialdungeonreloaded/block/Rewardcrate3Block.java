package net.kasaneta.specialdungeonreloaded.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class Rewardcrate3Block extends Block {
	public Rewardcrate3Block() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.1f, 0f));
	}
}