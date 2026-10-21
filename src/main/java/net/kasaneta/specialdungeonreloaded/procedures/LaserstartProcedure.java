package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class LaserstartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:gamestarted")), SoundSource.NEUTRAL, 1, (float) 0.75);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:gamestarted")), SoundSource.NEUTRAL, 1, (float) 0.75, false);
			}
		}
		if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
			StringBuilder _titleTextBuilder = new StringBuilder();
			_titleTextBuilder.append((Component.translatable("game.laser.started").getString()));
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
			_titleTextBuilder.append((Component.translatable("game.laser.started2").getString()));
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
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("lasergame_score");
				if (_so == null)
					_so = _sc.addObjective("lasergame_score", ObjectiveCriteria.DUMMY, Component.literal("lasergame_score"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
		}
	}
}