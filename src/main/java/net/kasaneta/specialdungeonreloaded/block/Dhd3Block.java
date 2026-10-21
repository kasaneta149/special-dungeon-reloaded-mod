package net.kasaneta.specialdungeonreloaded.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.procedures.Dhd3OnTickUpdateProcedure;

import com.mojang.serialization.MapCodec;

public class Dhd3Block extends FallingBlock {
	public static final MapCodec<Dhd3Block> CODEC = simpleCodec(properties -> new Dhd3Block());

	public MapCodec<Dhd3Block> codec() {
		return CODEC;
	}

	public Dhd3Block() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.death")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt_closed")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.deepslate.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.big_fall"))))
				.strength(-1, 3600000).lightLevel(blockstate -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 30);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		Dhd3OnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 30);
	}
}