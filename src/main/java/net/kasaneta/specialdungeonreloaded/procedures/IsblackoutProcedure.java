package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class IsblackoutProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).blackout;
	}
}