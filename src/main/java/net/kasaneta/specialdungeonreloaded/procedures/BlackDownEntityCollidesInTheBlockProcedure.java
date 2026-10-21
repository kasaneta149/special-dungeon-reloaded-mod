package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class BlackDownEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (getPropertyByName(blockstate, "canuse") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			if (entity instanceof Player == true) {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:building"))) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("canuse") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
					}
					{
						SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
						_vars.zone_current_floor = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor - 1;
						_vars.blackout = true;
						_vars.markSyncDirty();
					}
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "blackbox"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(5, 5, 5), new BlockPos(5, 5, 5), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					{
						Entity _ent = entity;
						double _tx = 6;
						double _ty = 6.1;
						double _tz = 6;
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					SpecialDungeonReloadedMod.queueServerWork(20, () -> {
						if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
							StringBuilder _titleTextBuilder = new StringBuilder();
							_titleTextBuilder.append((new java.text.DecimalFormat("#").format(entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor + 1)));
							String _titleText = _titleTextBuilder.toString();
							net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
							int _fadeTicks = (int) (3 * 20.0D);
							int _holdTicks = (int) (2 * 20.0D);
							java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
							net.minecraft.world.entity.player.Player _closest = _servLvl.getNearestPlayer((double) (entity.getX()), (double) (entity.getY()), (double) (entity.getZ()), 100.0D, false);
							if (_closest instanceof net.minecraft.server.level.ServerPlayer _sp) {
								_targetPlayers.add(_sp);
							}
							for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
								_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
								_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket(_comp));
							}
						}
					});
					SpecialDungeonReloadedMod.queueServerWork(100, () -> {
						if (world instanceof net.minecraft.server.level.ServerLevel _servLvl) {
							StringBuilder _titleTextBuilder = new StringBuilder();
							_titleTextBuilder.append((new java.text.DecimalFormat("#").format(entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).zone_current_floor)));
							String _titleText = _titleTextBuilder.toString();
							net.minecraft.network.chat.Component _comp = net.minecraft.network.chat.Component.literal(_titleText);
							int _fadeTicks = (int) (0 * 20.0D);
							int _holdTicks = (int) (2 * 20.0D);
							java.util.List<net.minecraft.server.level.ServerPlayer> _targetPlayers = new java.util.ArrayList<>();
							net.minecraft.world.entity.player.Player _closest = _servLvl.getNearestPlayer((double) (entity.getX()), (double) (entity.getY()), (double) (entity.getZ()), 100.0D, false);
							if (_closest instanceof net.minecraft.server.level.ServerPlayer _sp) {
								_targetPlayers.add(_sp);
							}
							for (net.minecraft.server.level.ServerPlayer _sp : _targetPlayers) {
								_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket(_fadeTicks, _holdTicks, _fadeTicks));
								_sp.connection.send(new net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket(_comp));
							}
						}
					});
					SpecialDungeonReloadedMod.queueServerWork(160, () -> {
						{
							SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
							_vars.blackout = false;
							_vars.markSyncDirty();
						}
						BuildingPlayerEntersDimensionProcedure.execute(world, entity);
					});
					SpecialDungeonReloadedMod.queueServerWork(170, () -> {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("canuse") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					});
				}
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}