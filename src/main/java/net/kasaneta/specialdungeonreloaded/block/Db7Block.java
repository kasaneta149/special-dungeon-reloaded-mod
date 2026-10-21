package net.kasaneta.specialdungeonreloaded.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.Dogblockbreak_xpProcedure;

import com.mojang.serialization.MapCodec;

public class Db7Block extends FallingBlock {
	public static final MapCodec<Db7Block> CODEC = simpleCodec(properties -> new Db7Block());

	public MapCodec<Db7Block> codec() {
		return CODEC;
	}

	public Db7Block() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.death")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt_closed")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.deepslate.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall"))))
				.strength(20f, 35f).lightLevel(blockstate -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		Dogblockbreak_xpProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}