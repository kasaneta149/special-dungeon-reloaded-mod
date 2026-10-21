package net.kasaneta.specialdungeonreloaded.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.Dogblockbreak_xpProcedure;

import com.mojang.serialization.MapCodec;

public class Db1goldBlock extends FallingBlock {
	public static final MapCodec<Db1goldBlock> CODEC = simpleCodec(properties -> new Db1goldBlock());

	public MapCodec<Db1goldBlock> codec() {
		return CODEC;
	}

	public Db1goldBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.death")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt_closed")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.deepslate.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall"))))
				.strength(100f, 35f).lightLevel(blockstate -> 15));
	}

	@Override
	public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, BlockEntity blockEntity, Entity breaker, ItemStack tool) {
		return Mth.randomBetweenInclusive(level.getRandom(), 0, 45);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		Dogblockbreak_xpProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}