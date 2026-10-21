package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class LsoceandosPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SpecialDungeonReloadedMod.queueServerWork(5, () -> {
			{
				Entity _ent = entity;
				double _tx = 80;
				double _ty = 100;
				double _tz = 60;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		});
	}
}