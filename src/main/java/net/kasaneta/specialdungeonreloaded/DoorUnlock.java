package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class DoorUnlock {
	public static final int WHITE = 0xFFFFFF;
	public static final int RED = 0xFF5555;
	public static final int BLACK = 0x000000;
	public static final int DARK_BLUE = 0x0000AA;
	public static final int BROWN = 0x996633;
	public static final int AQUA = 0x55FFFF;
	public static final int GRAY = 0xAAAAAA;
	public static final int GREEN = 0x55FF55;
	public static final int LIME = 0x00CC00;
	public static final int GOLD = 0xFFAA00;
	public static final int YELLOW = 0xFFFF55;
	public static final int PURPLE = 0xAA00AA;

	private static final String UNLOCKED_KEY = "dungeons.doors.unlocked";
	private static final SoundEvent OPEN_DOOR = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "open_door"));

	public static void open(LevelAccessor world, double x, double y, double z, BlockState blockstate, int nameColor, int unlockedColor, float pitch) {
		unlock(world, x, y, z, blockstate.getBlock().getName(), nameColor, unlockedColor, pitch);
	}

	public static void openNamed(LevelAccessor world, double x, double y, double z, String nameKey, int nameColor, int unlockedColor, float pitch) {
		unlock(world, x, y, z, Component.translatable(nameKey), nameColor, unlockedColor, pitch);
	}

	private static void unlock(LevelAccessor world, double x, double y, double z, MutableComponent name, int nameColor, int unlockedColor, float pitch) {
		BlockPos pos = BlockPos.containing(x, y, z);
		if (world instanceof ServerLevel level) {
			level.playSound(null, pos, OPEN_DOOR, SoundSource.BLOCKS, 1, pitch);
			Player player = level.getNearestPlayer(x, y, z, -1, false);
			if (player != null)
				player.displayClientMessage(message(name, nameColor, unlockedColor), true);
		}
		world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
	}

	private static Component message(MutableComponent name, int nameColor, int unlockedColor) {
		MutableComponent title = name.append(":").withStyle(Style.EMPTY.withColor(TextColor.fromRgb(nameColor)));
		MutableComponent unlocked = Component.translatable(UNLOCKED_KEY).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(unlockedColor)));
		return Component.empty().append(title).append(" ").append(unlocked);
	}
}