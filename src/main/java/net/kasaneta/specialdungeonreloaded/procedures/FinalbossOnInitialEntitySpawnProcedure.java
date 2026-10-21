package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class FinalbossOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("FINAL SPAWNED"), false);
		}
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getStringUUID())), false);
		}
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).finalbossuuid = entity.getStringUUID();
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
	}
}