package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class DreamdimentionPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!SpecialDungeonReloadedModVariables.WorldVariables.get(world).dreamgenerated) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).dreamgenerated = true;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "dreamstruct"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 5, 0), new BlockPos(0, 5, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "feteforaine"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(32, 4, 32), new BlockPos(32, 4, 32), new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
		SpecialDungeonReloadedMod.queueServerWork(5, () -> {
			{
				Entity _ent = entity;
				double _tx = 17;
				double _ty = 25;
				double _tz = 17;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		});
	}
}