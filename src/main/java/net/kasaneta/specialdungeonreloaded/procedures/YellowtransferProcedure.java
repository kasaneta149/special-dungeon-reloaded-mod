package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class YellowtransferProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double dungeonid = 0;
		double waittimer = 0;
		if (SpecialDungeonReloadedModVariables.DungeonIsDebug) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("[DEBUG] Current dungeon ID: " + SpecialDungeonReloadedModVariables.debugFloor)), false);
			dungeonid = SpecialDungeonReloadedModVariables.debugFloor;
		} else {
			dungeonid = Mth.nextInt(RandomSource.create(), 1, 10);
		}
		waittimer = 5;
		if (dungeonid == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow1"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 10;
					double _ty = 4.2;
					double _tz = 5;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow2"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(100, 0, 100), new BlockPos(100, 0, 100), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 105;
					double _ty = 1.2;
					double _tz = 118;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow3"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(200, 0, 200), new BlockPos(200, 0, 200), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 207;
					double _ty = 3;
					double _tz = 207;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow4"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(300, 0, 300), new BlockPos(300, 0, 300), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 304;
					double _ty = 8.5;
					double _tz = 303;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow5"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(400, 0, 400), new BlockPos(400, 0, 400), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 404;
					double _ty = 3;
					double _tz = 406;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 6) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow6"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(500, 0, 500), new BlockPos(500, 0, 500), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 504;
					double _ty = 2;
					double _tz = 503;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 7) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow7"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(600, 0, 600), new BlockPos(600, 0, 600), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 601;
					double _ty = 2;
					double _tz = 611;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 8) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow8"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(700, 0, 700), new BlockPos(700, 0, 700), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 703;
					double _ty = 3;
					double _tz = 703;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 9) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow9"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(800, 0, 800), new BlockPos(800, 0, 800), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 806;
					double _ty = 2;
					double _tz = 810;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 10) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "yellow10"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(900, 0, 900), new BlockPos(900, 0, 900), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 902;
					double _ty = 2;
					double _tz = 902;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		}
	}
}