package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class BuildingPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double waittimer = 0;
		double dungeonid = 0;
		double dungeonoffset = 0;
		double rf = 0;
		if (SpecialDungeonReloadedModVariables.DungeonIsDebug) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("[DEBUG] Current dungeon ID: " + SpecialDungeonReloadedModVariables.debugFloor)), false);
			dungeonid = SpecialDungeonReloadedModVariables.debugFloor;
			rf = SpecialDungeonReloadedModVariables.debugFloor;
		} else {
			dungeonid = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor % 25;
			rf = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor;
		}
		waittimer = 5;
		dungeonoffset = 100 * rf;
		if (dungeonid == 0) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 2.5;
				double _tz = (dungeonoffset + 3);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 1) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 4);
				double _ty = 3.2;
				double _tz = (dungeonoffset + 6);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 2) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 10);
				double _ty = 3.2;
				double _tz = (dungeonoffset + 10);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 3) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 15);
				double _ty = 2.5;
				double _tz = (dungeonoffset + 16);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 4) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 6);
				double _ty = 3.2;
				double _tz = (dungeonoffset + 11);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 5) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor6"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 2);
				double _ty = 18;
				double _tz = (dungeonoffset + 25);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 6) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor7"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 21);
				double _ty = 2.2;
				double _tz = (dungeonoffset + 21);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 7) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor8"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 14);
				double _ty = 2.2;
				double _tz = (dungeonoffset + 15);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 8) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor9"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 3;
				double _tz = (dungeonoffset + 6);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 9) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor10"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 11);
				double _ty = 3;
				double _tz = (dungeonoffset + 3);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 10) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor11"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 3.2;
				double _tz = (dungeonoffset + 9);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 11) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor12"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 11);
				double _ty = 4;
				double _tz = (dungeonoffset + 12);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 12) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor13"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 3;
				double _tz = (dungeonoffset + 11);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 13) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor14"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 3;
				double _tz = (dungeonoffset + 4);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 14) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor15"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 10);
				double _ty = 3;
				double _tz = (dungeonoffset + 12);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 15) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor16"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 13);
				double _ty = 3;
				double _tz = (dungeonoffset + 12);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 16) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor17"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 14);
				double _ty = 3;
				double _tz = (dungeonoffset + 13);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 17) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor18"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 14);
				double _ty = 3;
				double _tz = (dungeonoffset + 3);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 18) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor19"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 11);
				double _ty = 3;
				double _tz = (dungeonoffset + 20);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 19) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor20"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 9);
				double _ty = 3;
				double _tz = (dungeonoffset + 6);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 20) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor21"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 9);
				double _ty = 3;
				double _tz = (dungeonoffset + 6);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 21) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor22"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 9);
				double _ty = 3;
				double _tz = (dungeonoffset + 3);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 22) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor23"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 3);
				double _ty = 3;
				double _tz = (dungeonoffset + 7);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 23) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor24"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 9);
				double _ty = 3;
				double _tz = (dungeonoffset + 8);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		} else if (dungeonid == 24) {
			if (SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached < rf) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "floor25_1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(dungeonoffset, 0, dungeonoffset), BlockPos.containing(dungeonoffset, 0, dungeonoffset),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
			}
			{
				Entity _ent = entity;
				double _tx = (dungeonoffset + 4);
				double _ty = 3;
				double _tz = (dungeonoffset + 9);
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		}
		if (rf > SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).maxflooreached = rf;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		}
	}
}