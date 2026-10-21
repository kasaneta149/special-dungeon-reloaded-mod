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

public class GreendimPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double waittimer = 0;
		double dungeonid = 0;
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
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green1"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 19;
					double _ty = 1.5;
					double _tz = 4;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green2"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(100, 0, 100), new BlockPos(100, 0, 100), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 110;
					double _ty = 1.5;
					double _tz = 116;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green3"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(200, 0, 200), new BlockPos(200, 0, 200), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 203;
					double _ty = 1.5;
					double _tz = 204;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green4"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(304, 0, 316), new BlockPos(304, 0, 316), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 307;
					double _ty = 3;
					double _tz = 332;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green5"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(400, 0, 400), new BlockPos(400, 0, 400), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 409;
					double _ty = 2.5;
					double _tz = 402;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 6) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green6"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(500, 0, 500), new BlockPos(500, 0, 500), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 504;
					double _ty = 8.5;
					double _tz = 504;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 7) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green7"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(600, 0, 600), new BlockPos(600, 0, 600), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 605;
					double _ty = 3;
					double _tz = 603;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 8) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green8"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(700, 0, 700), new BlockPos(700, 0, 700), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 703;
					double _ty = 2;
					double _tz = 715;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 9) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green9"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(800, 0, 800), new BlockPos(800, 0, 800), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 802;
					double _ty = 2;
					double _tz = 802;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 10) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "green10"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(900, 0, 900), new BlockPos(900, 0, 900), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 901;
					double _ty = 2.1;
					double _tz = 902;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		}
	}
}