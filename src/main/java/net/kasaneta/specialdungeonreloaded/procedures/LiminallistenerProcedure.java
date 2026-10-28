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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;

import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber
public class LiminallistenerProcedure {
	private static final String NAMESPACE = "special_dungeon_reloaded";

	private static final int CELL_SIZE = 48;
	private static final int PRELOAD_RADIUS = 3;
	private static final int PRELOAD_INTERVAL = 5;
	private static final int MARKER_Y = 20;
	private static final int STRUCTURE_Y = 150;
	private static final int PLACE_FLAGS = 2;

	private static final ResourceLocation BEACH = id("lsbeachdim");
	private static final ResourceLocation CAMPEMENT = id("lscampement");
	private static final ResourceLocation VILLE_INFINIE = id("lsvilleinfinie");
	private static final ResourceLocation CAVE = id("lslacavedim");
	private static final ResourceLocation PISCINE = id("lspiscinedim");
	private static final ResourceLocation MAISON_INONDEE = id("lsmaisoninonde");
	private static final ResourceLocation CENTRE_COMMERCIAL = id("lscentrecommercialdim");
	private static final ResourceLocation STATION_ESSENCE = id("lsstationessencedim");
	private static final ResourceLocation CHAMP_ROUGE = id("lschamprougedim");
	private static final ResourceLocation CHAMP_INFINI = id("lschampinfini");
	private static final ResourceLocation BUREAU = id("lsbureaudim");
	private static final ResourceLocation BUREAU_ABANDONNE = id("lsbureauabandonedim");
	private static final ResourceLocation ETAT_DE_FOLIE = id("lsetatdefoliedim");

	private static final ResourceKey<Level> CAMPEMENT_KEY = ResourceKey.create(Registries.DIMENSION, CAMPEMENT);
	private static final ResourceKey<Level> CAVE_KEY = ResourceKey.create(Registries.DIMENSION, CAVE);
	private static final ResourceKey<DamageType> VOID_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, id("voiddamage"));

	private static final SoundEvent SCREAM_LONG = SoundEvent.createVariableRangeEvent(id("scramer_long"));
	private static final SoundEvent SCREAM_SHORT = SoundEvent.createVariableRangeEvent(id("screamer1s"));

	private interface Picker {
		String pick(int gridX, int gridZ, RandomSource random);
	}

	private static final Map<ResourceLocation, Picker> PICKERS = new HashMap<>();
	private static final Map<ResourceKey<Level>, LongOpenHashSet> DONE = new HashMap<>();

	static {
		PICKERS.put(BEACH, LiminallistenerProcedure::beach);
		PICKERS.put(CAMPEMENT, LiminallistenerProcedure::campement);
		PICKERS.put(VILLE_INFINIE, LiminallistenerProcedure::villeInfinie);
		PICKERS.put(CAVE, LiminallistenerProcedure::cave);
		PICKERS.put(PISCINE, LiminallistenerProcedure::piscine);
		PICKERS.put(MAISON_INONDEE, LiminallistenerProcedure::maisonInondee);
		PICKERS.put(CENTRE_COMMERCIAL, LiminallistenerProcedure::centreCommercial);
		PICKERS.put(STATION_ESSENCE, LiminallistenerProcedure::stationEssence);
		PICKERS.put(CHAMP_ROUGE, LiminallistenerProcedure::champRouge);
		PICKERS.put(CHAMP_INFINI, LiminallistenerProcedure::champInfini);
		PICKERS.put(BUREAU, LiminallistenerProcedure::bureau);
		PICKERS.put(BUREAU_ABANDONNE, LiminallistenerProcedure::bureauAbandonne);
		PICKERS.put(ETAT_DE_FOLIE, LiminallistenerProcedure::etatDeFolie);
	}

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
		if (!NAMESPACE.equals(dimension.getNamespace()))
			return;
		if (dimension.equals(BEACH)) {
			if (entity.getY() >= 200) {
				teleport(entity, Level.OVERWORLD);
				return;
			}
			if (entity.getX() >= 500) {
				teleport(entity, CAMPEMENT_KEY);
				return;
			}
		} else if (dimension.equals(VILLE_INFINIE) && Math.abs(entity.getX()) >= 350) {
			teleport(entity, CAVE_KEY);
			return;
		} else if (dimension.equals(ETAT_DE_FOLIE) && entity instanceof LivingEntity living) {
			applyMadness(level, living);
		}
		Picker picker = PICKERS.get(dimension);
		if (picker != null)
			generateAround(level, dimension, picker, entity);
	}

	private static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
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

	private static void playSound(ServerLevel level, Entity entity, SoundEvent sound) {
		if (!(entity instanceof ServerPlayer player))
			return;
		player.connection.send(new ClientboundSoundPacket(Holder.direct(sound), SoundSource.NEUTRAL, player.getX(), player.getY(), player.getZ(), 1, 1, level.getRandom().nextLong()));
	}

	private static void addEffect(LivingEntity entity, Holder<MobEffect> effect, int duration, int amplifier) {
		entity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false));
	}

	private static void voidDamage(ServerLevel level, LivingEntity entity, float amount) {
		entity.hurt(new DamageSource(level.holderOrThrow(VOID_DAMAGE)), amount);
	}

	private static void applyMadness(ServerLevel level, LivingEntity entity) {
		RandomSource random = level.getRandom();
		if (random.nextInt(251) != 5)
			return;
		double roll = random.nextDouble();
		if (roll >= 0.9) {
			addEffect(entity, MobEffects.DARKNESS, 200, 1);
			addEffect(entity, MobEffects.BLINDNESS, 200, 1);
			voidDamage(level, entity, 6 + random.nextInt(12));
			if (random.nextBoolean()) {
				addEffect(entity, SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 45, 1);
				playSound(level, entity, SCREAM_LONG);
			} else {
				addEffect(entity, SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 20, 1);
				playSound(level, entity, SCREAM_SHORT);
			}
		} else if (roll >= 0.7) {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			addEffect(entity, MobEffects.DARKNESS, 200, 1);
			addEffect(entity, MobEffects.BLINDNESS, 200, 1);
		} else if (roll >= 0.58) {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			voidDamage(level, entity, 1 + random.nextInt(5));
			addEffect(entity, MobEffects.CONFUSION, 200, 1);
		} else {
			addEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, 200, 2);
			addEffect(entity, MobEffects.CONFUSION, 200, 1);
		}
	}

	private static void generateAround(ServerLevel level, ResourceLocation dimension, Picker picker, Entity entity) {
		LongOpenHashSet done = DONE.computeIfAbsent(level.dimension(), key -> new LongOpenHashSet());
		int centerX = Math.floorDiv(Mth.floor(entity.getX()), CELL_SIZE);
		int centerZ = Math.floorDiv(Mth.floor(entity.getZ()), CELL_SIZE);

		if (processCell(level, dimension, picker, done, centerX, centerZ, true))
			return;

		if (entity.tickCount % PRELOAD_INTERVAL != 0)
			return;
		for (int ring = 1; ring <= PRELOAD_RADIUS; ring++) {
			for (int dx = -ring; dx <= ring; dx++) {
				int step = Math.abs(dx) == ring ? 1 : 2 * ring;
				for (int dz = -ring; dz <= ring; dz += step) {
					if (processCell(level, dimension, picker, done, centerX + dx, centerZ + dz, false))
						return;
				}
			}
		}
	}

	private static boolean processCell(ServerLevel level, ResourceLocation dimension, Picker picker, LongOpenHashSet done, int cellX, int cellZ, boolean mandatory) {
		long key = ((long) cellX << 32) ^ (cellZ & 0xFFFFFFFFL);
		if (done.contains(key))
			return false;
		int gridX = cellX * CELL_SIZE;
		int gridZ = cellZ * CELL_SIZE;
		if (!isReachable(dimension, gridX)) {
			done.add(key);
			return false;
		}
		BlockPos marker = new BlockPos(gridX, MARKER_Y, gridZ);
		if (!mandatory && !level.hasChunksAt(marker, new BlockPos(gridX + CELL_SIZE - 1, MARKER_Y, gridZ + CELL_SIZE - 1)))
			return false;
		done.add(key);
		if (level.getBlockState(marker).is(Blocks.BEDROCK))
			return false;
		level.setBlock(marker, Blocks.BEDROCK.defaultBlockState(), PLACE_FLAGS);
		String name = picker.pick(gridX, gridZ, level.getRandom());
		if (name == null)
			return false;
		StructureTemplate template = level.getStructureManager().getOrCreate(id(name));
		BlockPos origin = new BlockPos(gridX, STRUCTURE_Y, gridZ);
		template.placeInWorld(level, origin, origin, new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), level.getRandom(), PLACE_FLAGS);
		return true;
	}

	private static boolean isReachable(ResourceLocation dimension, int gridX) {
		if (dimension.equals(BEACH))
			return gridX < 500;
		if (dimension.equals(VILLE_INFINIE))
			return gridX < 350 && gridX + CELL_SIZE > -350;
		return true;
	}

	private static String beach(int gridX, int gridZ, RandomSource random) {
		if (gridX > 0)
			return "ls_beach_sand";
		if (gridX < 0)
			return "ls_beach_ocean";
		return switch (random.nextInt(6)) {
			case 0 -> "ls_beach_main";
			case 1 -> "ls_beach_main_sec2";
			case 2 -> "ls_beach_main_sec3";
			case 3 -> "ls_beach_main_sec4";
			case 4 -> "ls_beach_main_sec5";
			default -> random.nextDouble() >= 0.93 ? "ls_beach_main_sec6_withdog" : "ls_beach_main_sec6";
		};
	}

	private static String campement(int gridX, int gridZ, RandomSource random) {
		if (gridX == 0 && gridZ == 0)
			return "ls_campement_main";
		return random.nextDouble() >= 0.83 ? "ls_campement_forest2" : "ls_campement_forest1";
	}

	private static String villeInfinie(int gridX, int gridZ, RandomSource random) {
		return random.nextDouble() >= 0.94 ? "ls_ville_infinie_1_bus" : "ls_ville_infinie_1";
	}

	private static String cave(int gridX, int gridZ, RandomSource random) {
		if (random.nextDouble() < 0.7)
			return "ls_la_cave_1";
		double roll = random.nextDouble();
		if (roll >= 0.9)
			return "ls_la_cave_8";
		if (roll >= 0.85)
			return "ls_la_cave_7";
		if (roll >= 0.8)
			return "ls_la_cave_6";
		if (roll >= 0.7)
			return "ls_la_cave_5";
		if (roll >= 0.6)
			return "ls_la_cave_4";
		if (roll >= 0.3)
			return "ls_la_cave_3";
		if (roll >= 0.15)
			return "ls_la_cave_2";
		return "ls_la_cave_1";
	}

	private static String piscine(int gridX, int gridZ, RandomSource random) {
		return "lslapiscine_" + (1 + random.nextInt(3));
	}

	private static String maisonInondee(int gridX, int gridZ, RandomSource random) {
		if (gridX == 0 && gridZ == 0)
			return "lsmaisoninonde";
		if (random.nextDouble() >= 0.55)
			return "lsmaisoninonde_ocean";
		return switch (random.nextInt(4)) {
			case 0 -> "lsmaisoninonde_ocean";
			case 1 -> "lsmaisoninonde_ocean_stal1";
			case 2 -> "lsmaisoninonde_ocean_stal2";
			default -> {
				double roll = random.nextDouble();
				yield roll >= 0.55 ? "lsmaisoninonde_ocean_stal3" : roll >= 0.35 ? "lsmaisoninonde_ocean_stal4_bus" : "lsmaisoninonde_ocean_stal5_market";
			}
		};
	}

	private static String centreCommercial(int gridX, int gridZ, RandomSource random) {
		if (gridX != 0)
			return null;
		return switch (random.nextInt(3)) {
			case 0 -> "lscentrecommercial";
			case 1 -> "lscentrecommercial_alt";
			default -> random.nextDouble() >= 0.95 ? "lscentrecommercial_middle_portal" : "lscentrecommercial_middle";
		};
	}

	private static String stationEssence(int gridX, int gridZ, RandomSource random) {
		if (gridX != 0)
			return random.nextDouble() >= 0.8 ? "lsstationessence_monster_forest" : "lsstationessence_forest";
		if (gridZ == 0)
			return "lsstationessence";
		double roll = random.nextDouble();
		if (roll >= 0.9)
			return gridZ >= 400 ? "lsstationessence_road_monster_forest_bus" : "lsstationessence_road_monster_forest3";
		if (roll >= 0.83) {
			return switch (random.nextInt(3)) {
				case 0 -> "lsstationessence_road_monster_forest2";
				case 1 -> "lsstationessence_road_monster_forest";
				default -> "lsstationessence_road_monster_forest3";
			};
		}
		return "lsstationessence_road";
	}

	private static String champRouge(int gridX, int gridZ, RandomSource random) {
		return random.nextDouble() >= 0.85 ? "lschamprouge_hole" : "lschamprouge";
	}

	private static String champInfini(int gridX, int gridZ, RandomSource random) {
		double roll = random.nextDouble();
		if (roll >= 0.88)
			return "lschampinfini_bureau_entrace";
		if (roll >= 0.75)
			return "lschampinfini_pilleur";
		return "lschampinfini";
	}

	private static String bureau(int gridX, int gridZ, RandomSource random) {
		if (gridX == 0 && gridZ == 0)
			return "lslesbureau";
		return random.nextDouble() >= 0.88 ? "lslesbureau_2" : "lslesbureau";
	}

	private static String bureauAbandonne(int gridX, int gridZ, RandomSource random) {
		if (gridX != 0)
			return null;
		return "lslesbureauabandonnes";
	}

	private static String etatDeFolie(int gridX, int gridZ, RandomSource random) {
		if (gridX == 0 && gridZ == 0)
			return "lsetatdefolie";
		double roll = random.nextDouble();
		if (roll >= 0.87)
			return "lsetatdefolie_bus";
		if (roll >= 0.79)
			return "lsetatdefolie_glass";
		return "lsetatdefolie";
	}
}
