package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.function.IntPredicate;

public class BuschairOnEntityTickUpdateProcedure {
	private static final String NAMESPACE = "special_dungeon_reloaded";
	private static final int CHECK_INTERVAL_TICKS = 10;

	private record Trip(ResourceKey<Level> destination, Set<Integer> times) {
	}

	private record DayPlan(IntPredicate days, List<Trip> trips) {
	}

	private static final Map<Integer, List<DayPlan>> SCHEDULES = Map.of(
		1, List.of(
			plan(everyDay(),
				trip("lschamprougedim", at(12, 30)))),
		2, List.of(
			plan(everyDay(),
				trip("lsbeachdim", at(10, 17), at(10, 21), at(10, 35), at(10, 58), at(11, 11), at(11, 40)))),
		3, List.of(
			plan(everyNDays(3),
				trip("lsstationessencedim", at(6, 10))),
			plan(everyNDays(2),
				trip("lspiscinedim", at(11, 10), at(13, 30))),
			plan(everyDay(),
				trip("lscentrecommercialdim",
					at(6, 11), at(6, 44),
					at(7, 0), at(7, 15), at(7, 30), at(7, 45),
					at(8, 0), at(8, 15), at(8, 30), at(8, 45),
					at(11, 1), at(11, 9), at(11, 15), at(11, 21), at(11, 33), at(11, 41), at(11, 49), at(11, 55),
					at(12, 1), at(12, 9), at(12, 15), at(12, 21), at(12, 33), at(12, 41), at(12, 49), at(12, 55),
					at(13, 1), at(13, 9), at(13, 15), at(13, 21), at(13, 33), at(13, 41), at(13, 49), at(13, 55)),
				trip("lsbureaudim", at(8, 10), at(18, 45)),
				trip("lsbureauabandonedim", at(22, 40), at(0, 28)))),
		4, List.of(
			plan(everyDay(),
				trip("lschampinfini", at(5, 40), at(17, 3)))),
		5, List.of(
			plan(everyNDays(57),
				trip("lsoceandos", at(0, 0)))));

	private static int at(int hour, int minute) {
		return hour * 60 + minute;
	}

	private static IntPredicate everyDay() {
		return day -> true;
	}

	private static IntPredicate everyNDays(int n) {
		return day -> Math.floorMod(day, n) == 0;
	}

	private static Trip trip(String dimension, int... times) {
		Set<Integer> minutes = new HashSet<>();
		for (int time : times)
			minutes.add(time);
		return new Trip(ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(NAMESPACE, dimension)), minutes);
	}

	private static DayPlan plan(IntPredicate days, Trip... trips) {
		return new DayPlan(days, List.of(trips));
	}

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null || world.isClientSide())
			return;
		if (entity.tickCount % CHECK_INTERVAL_TICKS != 0)
			return;
		if (!(entity.getFirstPassenger() instanceof ServerPlayer player))
			return;
		List<DayPlan> plans = SCHEDULES.get((int) entity.getPersistentData().getDouble("shedule_id"));
		if (plans == null)
			return;
		long dayTime = world.dayTime();
		int day = GameClock.day(dayTime);
		int minuteOfDay = GameClock.minuteOfDay(dayTime);
		for (DayPlan plan : plans) {
			if (!plan.days().test(day))
				continue;
			for (Trip trip : plan.trips()) {
				if (trip.times().contains(minuteOfDay)) {
					travel(player, trip.destination());
					return;
				}
			}
			return;
		}
	}

	private static void travel(ServerPlayer player, ResourceKey<Level> destination) {
		if (player.level().dimension().equals(destination))
			return;
		ServerLevel nextLevel = player.server.getLevel(destination);
		if (nextLevel == null)
			return;
		player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
		player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
		player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
		for (MobEffectInstance effect : player.getActiveEffects())
			player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effect, false));
		player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
	}
}