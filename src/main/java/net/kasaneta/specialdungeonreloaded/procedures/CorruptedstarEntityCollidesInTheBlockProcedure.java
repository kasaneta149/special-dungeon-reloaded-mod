package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class CorruptedstarEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity instanceof ServerPlayer player)
			OverworldExit.send(player);
	}
}