package net.kasaneta.specialdungeonreloaded.procedures;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.BlockPos;

import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber
public class LiminallistenerProcedure {
	private static final int PRELOAD_INTERVAL = 5;
	private static final int PLACE_FLAGS = 2;

	private static final Map<ResourceKey<Level>, LongOpenHashSet> DONE = new HashMap<>();

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Entity entity = event.getEntity();
		execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@SubscribeEvent
	public static void onServerStopped(ServerStoppedEvent event) {
		DONE.clear();
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || !(world instanceof ServerLevel level))
			return;
		ResourceLocation dimension = level.dimension().location();
		if (!LiminalLevel.NAMESPACE.equals(dimension.getNamespace()))
			return;
		LiminalLevel definition = LiminalLevels.get(dimension);
		if (definition == null)
			return;
		ResourceKey<Level> exit = definition.exitFor(entity);
		if (exit != null) {
			teleport(entity, exit);
			return;
		}
		definition.applyEffect(level, entity);
		generateAround(level, definition, entity);
	}

	private static void teleport(Entity entity, ResourceKey<Level> destination) {
		if (!(entity instanceof ServerPlayer player))
			return;
		ServerLevel nextLevel = player.server.getLevel(destination);
		if (nextLevel == null)
			return;
		player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
		player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
		player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
		for (MobEffectInstance effect : player.getActiveEffects())
			player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effect, false));
		player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
	}

	private static void generateAround(ServerLevel level, LiminalLevel definition, Entity entity) {
		LongOpenHashSet done = DONE.computeIfAbsent(level.dimension(), key -> new LongOpenHashSet());
		int centerX = Math.floorDiv(Mth.floor(entity.getX()), LiminalLevel.CELL_SIZE);
		int centerZ = Math.floorDiv(Mth.floor(entity.getZ()), LiminalLevel.CELL_SIZE);

		if (processCell(level, definition, done, centerX, centerZ, true))
			return;

		if (entity.tickCount % PRELOAD_INTERVAL != 0)
			return;
		int radius = definition.preloadRadius();
		for (int ring = 1; ring <= radius; ring++) {
			for (int dx = -ring; dx <= ring; dx++) {
				int step = Math.abs(dx) == ring ? 1 : 2 * ring;
				for (int dz = -ring; dz <= ring; dz += step) {
					if (processCell(level, definition, done, centerX + dx, centerZ + dz, false))
						return;
				}
			}
		}
	}

	private static boolean processCell(ServerLevel level, LiminalLevel definition, LongOpenHashSet done, int cellX, int cellZ, boolean mandatory) {
		if (!definition.allows(cellX, cellZ))
			return false;
		long key = ((long) cellX << 32) ^ (cellZ & 0xFFFFFFFFL);
		if (done.contains(key))
			return false;
		int gridX = cellX * LiminalLevel.CELL_SIZE;
		int gridZ = cellZ * LiminalLevel.CELL_SIZE;
		BlockPos marker = new BlockPos(gridX, definition.markerY(), gridZ);
		if (!mandatory && !level.hasChunksAt(marker, new BlockPos(gridX + LiminalLevel.CELL_SIZE - 1, definition.markerY(), gridZ + LiminalLevel.CELL_SIZE - 1)))
			return false;
		done.add(key);
		if (level.getBlockState(marker).is(Blocks.BEDROCK))
			return false;
		level.setBlock(marker, Blocks.BEDROCK.defaultBlockState(), PLACE_FLAGS);
		ResourceLocation structure = definition.pickStructure(gridX, gridZ, level.getRandom());
		if (structure == null)
			return false;
		StructureTemplate template = level.getStructureManager().getOrCreate(structure);
		BlockPos origin = new BlockPos(gridX, definition.structureY(), gridZ);
		template.placeInWorld(level, origin, origin, new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), level.getRandom(), PLACE_FLAGS);
		return true;
	}
}