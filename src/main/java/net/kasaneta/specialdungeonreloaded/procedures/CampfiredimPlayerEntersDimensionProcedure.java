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

import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class CampfiredimPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double waittimer = 0;
		double dungeonid = 0;
		waittimer = 5;
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "cor10"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		SpecialDungeonReloadedMod.queueServerWork((int) waittimer, () -> {
			{
				Entity _ent = entity;
				double _tx = 3;
				double _ty = 3;
				double _tz = 15;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		});
	}
}