package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

import java.util.ArrayList;

public class LasergamecontrollerRedstoneOffProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double mostscore = 0;
		if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
			StringBuilder _titleTextBuilder = new StringBuilder();
			_titleTextBuilder.append((Component.translatable("game.laser.finished").getString()));
			String _titleText = _titleTextBuilder.toString();
			net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
			int _fadeTicks = (int) (0.5 * 20.0D);
			int _holdTicks = (int) (3 * 20.0D);
			java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
			_targetPlayers.addAll(_servLvl.players());
			for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
				_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
				_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket(_comp));
			}
		}
		mostscore = -1;
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnerscore = -1;
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnername = "";
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (getEntityScore("lasergame_score", entityiterator) > mostscore) {
				SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnerscore = getEntityScore("lasergame_score", entityiterator);
				SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
				mostscore = getEntityScore("lasergame_score", entityiterator);
				SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnername = entityiterator.getDisplayName().getString();
				SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
			}
			{
				Entity _ent = entityiterator;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("lasergame_score");
				if (_so == null)
					_so = _sc.addObjective("lasergame_score", ObjectiveCriteria.DUMMY, Component.literal("lasergame_score"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
		}
		SpecialDungeonReloadedMod.queueServerWork(80, () -> {
			if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
				StringBuilder _titleTextBuilder = new StringBuilder();
				_titleTextBuilder.append((Component.translatable("game.laser.winneris").getString()));
				String _titleText = _titleTextBuilder.toString();
				net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
				int _fadeTicks = (int) (0.5 * 20.0D);
				int _holdTicks = (int) (3 * 20.0D);
				java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
				_targetPlayers.addAll(_servLvl.players());
				for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket(_comp));
				}
			}
		});
		SpecialDungeonReloadedMod.queueServerWork(180, () -> {
			if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
				StringBuilder _titleTextBuilder = new StringBuilder();
				_titleTextBuilder.append(SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnername);
				String _titleText = _titleTextBuilder.toString();
				net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
				int _fadeTicks = (int) (0.5 * 20.0D);
				int _holdTicks = (int) (3 * 20.0D);
				java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
				_targetPlayers.addAll(_servLvl.players());
				for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket(_comp));
				}
			}
			if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
				StringBuilder _titleTextBuilder = new StringBuilder();
				_titleTextBuilder.append(((Component.translatable("game.laser.winnercongrat").getString()).replace("%s", new java.text.DecimalFormat("#").format(SpecialDungeonReloadedModVariables.WorldVariables.get(world).lastwinnerscore))));
				String _titleText = _titleTextBuilder.toString();
				net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
				int _fadeTicks = (int) (0.5 * 20.0D);
				int _holdTicks = (int) (3 * 20.0D);
				java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
				_targetPlayers.addAll(_servLvl.players());
				for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
					_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket(_comp));
				}
			}
		});
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}