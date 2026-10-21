package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class FinalbossOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getStringUUID()).equals(SpecialDungeonReloadedModVariables.WorldVariables.get(world).finalbossuuid)) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).finalbossuuid = entity.getStringUUID();
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		}
	}
}