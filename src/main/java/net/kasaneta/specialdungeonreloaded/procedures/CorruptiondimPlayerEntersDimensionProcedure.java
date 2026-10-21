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

public class CorruptiondimPlayerEntersDimensionProcedure {
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
			dungeonid = Mth.nextInt(RandomSource.create(), 1, 13);
		}
		waittimer = 5;
		if (dungeonid == 1) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor1"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 2;
					double _ty = 2;
					double _tz = 2;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 2) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor2"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(100, 0, 100), new BlockPos(100, 0, 100), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 103;
					double _ty = 2.5;
					double _tz = 103;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 3) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor3"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(200, 0, 200), new BlockPos(200, 0, 200), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 202;
					double _ty = 2.5;
					double _tz = 202;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 4) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor4"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(300, 0, 300), new BlockPos(300, 0, 300), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 302;
					double _ty = 3;
					double _tz = 302;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 5) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor5"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(400, 0, 400), new BlockPos(400, 0, 400), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 404;
					double _ty = 3;
					double _tz = 404;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 6) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor6"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(500, 0, 500), new BlockPos(500, 0, 500), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 502;
					double _ty = 2.5;
					double _tz = 502;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 7) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor7"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(600, 0, 600), new BlockPos(600, 0, 600), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 603;
					double _ty = 4;
					double _tz = 612;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 8) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor8"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(700, 0, 700), new BlockPos(700, 0, 700), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 713;
					double _ty = 3;
					double _tz = 706;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 9) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor9"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(800, 0, 800), new BlockPos(800, 0, 800), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 803;
					double _ty = 3;
					double _tz = 803;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 10) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor11"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(900, 0, 900), new BlockPos(900, 0, 900), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 907;
					double _ty = 2.5;
					double _tz = 903;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 11) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor12"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1000, 0, 1000), new BlockPos(1000, 0, 1000), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 1004;
					double _ty = 2.5;
					double _tz = 1004;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 12) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor13"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1100, 0, 1100), new BlockPos(1100, 0, 1100), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 1102;
					double _ty = 2;
					double _tz = 1102;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		} else if (dungeonid == 13) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor14"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(1200, 0, 1200), new BlockPos(1200, 0, 1200), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
				{
					Entity _ent = entity;
					double _tx = 1202;
					double _ty = 2.2;
					double _tz = 1202;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			});
		}
	}
}