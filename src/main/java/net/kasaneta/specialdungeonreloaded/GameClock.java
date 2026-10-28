package net.kasaneta.specialdungeonreloaded.procedures;

public class GameClock {
	public static final int DAY_STARTS_AT_HOUR = 6;

	public static int day(long dayTime) {
		return (int) Math.floorDiv(dayTime + (6 - DAY_STARTS_AT_HOUR) * 1000L, 24000L);
	}

	public static int minuteOfDay(long dayTime) {
		return (int) ((Math.floorMod(dayTime, 24000L) * 3 / 50 + 6 * 60) % 1440);
	}

	public static int hour(long dayTime) {
		return minuteOfDay(dayTime) / 60;
	}

	public static int minute(long dayTime) {
		return minuteOfDay(dayTime) % 60;
	}
}