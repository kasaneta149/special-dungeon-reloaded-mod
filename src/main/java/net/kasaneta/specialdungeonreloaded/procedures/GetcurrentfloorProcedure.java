package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class GetcurrentfloorProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.building.floor").getString() + "" + new java.text.DecimalFormat("#").format(entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor);
	}
}