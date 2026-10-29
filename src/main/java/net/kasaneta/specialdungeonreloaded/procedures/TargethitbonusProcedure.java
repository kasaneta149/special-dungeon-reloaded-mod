package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class TargethitbonusProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity instanceof ServerPlayer player)
			LaserGame.reward(player, 1, "game.targethit3");
	}
}