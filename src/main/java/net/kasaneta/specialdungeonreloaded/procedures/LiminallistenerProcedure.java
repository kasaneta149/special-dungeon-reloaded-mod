package net.kasaneta.specialdungeonreloaded.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LiminallistenerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double gridX = 0;
		double gridZ = 0;
		double randomlol = 0;
		double structureid = 0;
		double PlayerX = 0;
		double PlayerZ = 0;
		double caveid = 0;
		double poolid = 0;
		if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbeachdim")) == (entity.level().dimension())) {
			if (entity.getY() >= 200) {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = Level.OVERWORLD;
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				return;
			}
			if (entity.getX() >= 500) {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lscampement"));
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				return;
			}
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			randomlol = Math.random();
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX > 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_sand"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (gridX < 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_ocean"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (gridX == 0) {
					structureid = Mth.nextInt(RandomSource.create(), 0, 5);
					if (structureid == 0) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (structureid == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (structureid == 2) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec3"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (structureid == 3) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec4"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (structureid == 4) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec5"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (structureid == 5) {
						if (Math.random() >= 0.93) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec6_withdog"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_beach_main_sec6"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lscampement")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX > 0) {
					if (Math.random() >= 0.83) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else if (gridX < 0) {
					if (Math.random() >= 0.83) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else if (gridX == 0) {
					if (gridZ == 0) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_main"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (Math.random() >= 0.83) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_campement_forest1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsvilleinfinie")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (entity.getX() >= 350) {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lslacavedim"));
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				return;
			}
			if (entity.getX() <= -350) {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lslacavedim"));
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				return;
			}
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (Math.random() >= 0.94) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_ville_infinie_1_bus"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_ville_infinie_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lslacavedim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (Math.random() >= 0.7) {
					caveid = Math.random();
					if (caveid >= 0.9) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_8"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.85) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_7"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.8) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_6"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.7) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_5"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.6) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_4"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.3) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_3"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (caveid >= 0.15) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "ls_la_cave_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lspiscinedim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				poolid = Mth.nextInt(RandomSource.create(), 1, 3);
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (poolid == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslapiscine_1"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (poolid == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslapiscine_2"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (poolid == 3) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslapiscine_3"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsmaisoninonde")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				poolid = Mth.nextInt(RandomSource.create(), 1, 4);
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX == 0 && gridZ == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (Math.random() >= 0.55) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (poolid == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (poolid == 2) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean_stal1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (poolid == 3) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean_stal2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (poolid == 4) {
							caveid = Math.random();
							if (caveid >= 0.55) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean_stal3"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else if (caveid >= 0.35) {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean_stal4_bus"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							} else {
								if (world instanceof ServerLevel _serverworld) {
									StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsmaisoninonde_ocean_stal5_market"));
									if (template != null) {
										template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
												new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
									}
								}
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lscentrecommercialdim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				poolid = Mth.nextInt(RandomSource.create(), 0, 2);
				if (gridX == 0) {
					if (poolid == 0) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lscentrecommercial"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (poolid == 1) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lscentrecommercial_alt"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (poolid == 2) {
						if (Math.random() >= 0.95) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lscentrecommercial_middle_portal"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lscentrecommercial_middle"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsstationessencedim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX == 0 && gridZ == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (gridX == 0 && gridZ != 0) {
					randomlol = Math.random();
					if (randomlol >= 0.9) {
						if (entity.getZ() >= 400) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road_monster_forest_bus"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road_monster_forest3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					} else if (randomlol >= 0.83) {
						poolid = Mth.nextInt(RandomSource.create(), 1, 3);
						if (poolid == 1) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road_monster_forest2"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (poolid == 2) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road_monster_forest"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if (poolid == 3) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road_monster_forest3"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_road"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				} else {
					if (Math.random() >= 0.8) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_monster_forest"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsstationessence_forest"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lschamprougedim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				randomlol = Math.random();
				if (randomlol >= 0.85) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lschamprouge_hole"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lschamprouge"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lschampinfini")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				randomlol = Math.random();
				if (randomlol >= 0.88) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lschampinfini_bureau_entrace"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (randomlol >= 0.75) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lschampinfini_pilleur"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lschampinfini"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbureaudim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX == 0 && gridZ == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslesbureau"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					randomlol = Math.random();
					if (randomlol >= 0.88) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslesbureau_2"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslesbureau"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbureauabandonedim")) == (entity.level().dimension())) {
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lslesbureauabandonnes"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			}
		} else if (ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsetatdefoliedim")) == (entity.level().dimension())) {
			if (Mth.nextInt(RandomSource.create(), 0, 250) == 5) {
				randomlol = Math.random();
				if (randomlol >= 0.9) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, false, false));
					entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("special_dungeon_reloaded:voiddamage")))), Mth.nextInt(RandomSource.create(), 6, 17));
					poolid = Mth.nextInt(RandomSource.create(), 1, 2);
					if (poolid == 1) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 45, 1, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:scramer_long")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:scramer_long")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (poolid == 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 20, 1, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:screamer1s")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:screamer1s")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(SpecialDungeonReloadedModMobEffects.NOTCARREFUL, 12, 1, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:screamer")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:screamer")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				} else if (randomlol >= 0.7) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, false, false));
				} else if (randomlol >= 0.58) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2, false, false));
					entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("special_dungeon_reloaded:voiddamage")))), Mth.nextInt(RandomSource.create(), 1, 5));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1, false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1, false, false));
				}
			}
			gridX = Math.floor(entity.getX() / 48) * 48;
			gridZ = Math.floor(entity.getZ() / 48) * 48;
			if (!((world.getBlockState(BlockPos.containing(gridX, 20, gridZ))).getBlock() == Blocks.BEDROCK)) {
				world.setBlock(BlockPos.containing(gridX, 20, gridZ), Blocks.BEDROCK.defaultBlockState(), 3);
				if (gridX == 0 && gridZ == 0) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsetatdefolie"));
						if (template != null) {
							template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else {
					randomlol = Math.random();
					if (randomlol >= 0.87) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsetatdefolie_bus"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if (randomlol >= 0.79) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsetatdefolie_glass"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "lsetatdefolie"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(gridX, 150, gridZ), BlockPos.containing(gridX, 150, gridZ),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
				}
			}
		}
	}
}