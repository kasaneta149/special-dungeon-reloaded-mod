package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class GetMoneyStringProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double added_moula = 0;
		return Component.translatable("ui.moulastring").getString() + ": " + new java.text.DecimalFormat("##.## \u20AC").format(entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money);
	}
}