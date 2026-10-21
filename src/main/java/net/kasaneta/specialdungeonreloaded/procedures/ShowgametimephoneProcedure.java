package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ShowgametimephoneProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double day = 0;
		double world_tick = 0;
		double hour = 0;
		double minute = 0;
		double tiz = 0;
		double total_min = 0;
		world_tick = world.dayTime();
		tiz = (world.dayTime() % 24000 + 24000) % 24000;
		total_min = Math.floor((tiz / 24000) * 1440);
		day = world_tick / 24000;
		hour = Math.floor(total_min / 60) + 6;
		minute = total_min % 60;
		if (hour >= 24) {
			hour = hour - 24;
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(
							(Component.translatable("phone.loc.date").getString() + ": " + new java.text.DecimalFormat("#").format(day) + " | " + new java.text.DecimalFormat("#").format(hour) + ":" + new java.text.DecimalFormat("#").format(minute))),
					true);
	}
}