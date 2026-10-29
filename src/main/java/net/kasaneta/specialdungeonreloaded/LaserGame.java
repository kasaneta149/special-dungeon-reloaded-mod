package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

import java.util.UUID;

public class LaserGame {
	public static final int WINNER_INTRO_DELAY = 80;
	public static final int WINNER_NAME_DELAY = 160;

	private static final int TITLE_FADE_TICKS = 10;
	private static final int TITLE_HOLD_TICKS = 60;
	private static final String SCORE = "lasergame_score";
	private static final String STARTED = "started";
	private static final String BOUND_MOB = "bound_mob";
	private static final SoundEvent GAME_STARTED = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "gamestarted"));

	private record Winner(String name, int score) {
	}

	public static void start(ServerLevel level, BlockPos pos) {
		level.playSound(null, pos, GAME_STARTED, SoundSource.NEUTRAL, 1, 0.75f);
		showTitle(level, Component.translatable("game.laser.started"), Component.translatable("game.laser.started2"));
		resetScores(level);
	}

	public static void finish(ServerLevel level) {
		showTitle(level, Component.translatable("game.laser.finished"), null);
		Winner winner = pickWinnerAndResetScores(level);
		SpecialDungeonReloadedModVariables.WorldVariables variables = SpecialDungeonReloadedModVariables.WorldVariables.get(level);
		variables.lastwinnerscore = winner.score();
		variables.lastwinnername = winner.name();
		variables.markSyncDirty();
		SpecialDungeonReloadedMod.queueServerWork(WINNER_INTRO_DELAY, () -> showTitle(level, Component.translatable("game.laser.winneris"), null));
		SpecialDungeonReloadedMod.queueServerWork(WINNER_NAME_DELAY, () -> showTitle(level, Component.literal(winner.name()), Component.translatable("game.laser.winnercongrat", winner.score())));
	}

	public static void reward(ServerPlayer player, int points, String messageKey) {
		Scoreboard scoreboard = player.serverLevel().getScoreboard();
		var score = scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(player.getScoreboardName()), objective(scoreboard));
		score.set(score.get() + points);
		player.displayClientMessage(Component.translatable(messageKey), true);
	}

	public static boolean isStarted(ServerLevel level, BlockPos pos) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		return blockEntity != null && blockEntity.getPersistentData().getBoolean(STARTED);
	}

	public static void setStarted(ServerLevel level, BlockPos pos, boolean started) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity == null)
			return;
		blockEntity.getPersistentData().putBoolean(STARTED, started);
		saveBlockData(level, pos, blockEntity);
	}

	public static Entity getBoundTarget(ServerLevel level, BlockPos pos) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity == null)
			return null;
		String uuid = blockEntity.getPersistentData().getString(BOUND_MOB);
		if (uuid.isEmpty())
			return null;
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public static void setBoundTarget(ServerLevel level, BlockPos pos, String uuid) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity == null || blockEntity.getPersistentData().getString(BOUND_MOB).equals(uuid))
			return;
		blockEntity.getPersistentData().putString(BOUND_MOB, uuid);
		saveBlockData(level, pos, blockEntity);
	}

	private static void saveBlockData(ServerLevel level, BlockPos pos, BlockEntity blockEntity) {
		blockEntity.setChanged();
		BlockState state = level.getBlockState(pos);
		level.sendBlockUpdated(pos, state, state, 3);
	}

	private static Objective objective(Scoreboard scoreboard) {
		Objective objective = scoreboard.getObjective(SCORE);
		if (objective == null)
			objective = scoreboard.addObjective(SCORE, ObjectiveCriteria.DUMMY, Component.literal(SCORE), ObjectiveCriteria.RenderType.INTEGER, true, null);
		return objective;
	}

	private static void resetScores(ServerLevel level) {
		Scoreboard scoreboard = level.getScoreboard();
		Objective objective = objective(scoreboard);
		for (ServerPlayer player : level.players())
			scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(player.getScoreboardName()), objective).set(0);
	}

	private static Winner pickWinnerAndResetScores(ServerLevel level) {
		Scoreboard scoreboard = level.getScoreboard();
		Objective objective = objective(scoreboard);
		String winnerName = "";
		int winnerScore = -1;
		for (ServerPlayer player : level.players()) {
			var score = scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(player.getScoreboardName()), objective);
			if (score.get() > winnerScore) {
				winnerScore = score.get();
				winnerName = player.getDisplayName().getString();
			}
			score.set(0);
		}
		return new Winner(winnerName, winnerScore);
	}

	private static void showTitle(ServerLevel level, Component title, Component subtitle) {
		ClientboundSetTitlesAnimationPacket times = new ClientboundSetTitlesAnimationPacket(TITLE_FADE_TICKS, TITLE_HOLD_TICKS, TITLE_FADE_TICKS);
		for (ServerPlayer player : level.players()) {
			player.connection.send(times);
			if (subtitle != null)
				player.connection.send(new ClientboundSetSubtitleTextPacket(subtitle));
			if (title != null)
				player.connection.send(new ClientboundSetTitleTextPacket(title));
		}
	}
}