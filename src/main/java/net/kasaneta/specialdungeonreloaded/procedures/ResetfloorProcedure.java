package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class ResetfloorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
			_vars.zone_current_floor = 0;
			_vars.markSyncDirty();
		}
	}
}