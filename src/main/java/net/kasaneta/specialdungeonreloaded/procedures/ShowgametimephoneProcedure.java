package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ShowgametimephoneProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player player && !player.level().isClientSide()) {
			long dayTime = world.dayTime();
			String time = String.format(": %d | %d:%02d", GameClock.day(dayTime), GameClock.hour(dayTime), GameClock.minute(dayTime));
			player.displayClientMessage(Component.translatable("phone.loc.date").append(time), true);
		}
	}
}