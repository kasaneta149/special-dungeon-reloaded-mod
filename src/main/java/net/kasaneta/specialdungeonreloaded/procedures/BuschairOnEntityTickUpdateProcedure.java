package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
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

public class BuschairOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
 return;
		Entity le_joueur = null;
		double day = 0;
		double world_tick = 0;
		double hour = 0;
		double minute = 0;
		double total_min = 0;
		double tiz = 0;
		double shedule_id = 0;
		if (entity.getPersistentData().getDouble("nextCheck") > 0) {
			entity.getPersistentData().putDouble("nextCheck", (entity.getPersistentData().getDouble("nextCheck") - 1));
		} else {
			entity.getPersistentData().putDouble("nextCheck", 15);
			shedule_id = entity.getPersistentData().getDouble("shedule_id");
			world_tick = world.dayTime();
			tiz = (world.dayTime() % 24000 + 24000) % 24000;
			total_min = Math.floor((tiz / 24000) * 1440);
			day = world_tick / 24000;
			hour = Math.floor(total_min / 60) + 6;
			minute = total_min % 60;
			if (hour >= 24) hour -= 24;
			if (entity.isVehicle()) {
				le_joueur = entity.getFirstPassenger();
				if (le_joueur != null) {
					if (le_joueur instanceof Player) {
						if (shedule_id == 2) {
							if (
								(hour == 10 && minute == 17) || 
								(hour == 10 && minute == 21) || 
								(hour == 10 && minute == 35) || 
								(hour == 10 && minute == 58) || 
								(hour == 11 && minute == 11) || 
								(hour == 11 && minute == 40)
							) {
								if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbeachdim"));
									if (_player.level().dimension() == destinationType)
										return;
									ServerLevel nextLevel = _player.server.getLevel(destinationType);
									if (nextLevel != null) {
										_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
										_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
										_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
										for (MobEffectInstance _effectinstance : _player.getActiveEffects())
											_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
										_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
						}else if (shedule_id == 1) {
							if ((hour == 12 && minute == 30)) {
								if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lschamprougedim"));
									if (_player.level().dimension() == destinationType)
										return;
									ServerLevel nextLevel = _player.server.getLevel(destinationType);
									if (nextLevel != null) {
										_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
										_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
										_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
										for (MobEffectInstance _effectinstance : _player.getActiveEffects())
											_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
										_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
						}else if (shedule_id == 3) {
							if ((Math.floor(day) % 3)==0){
								if ((hour == 6 && minute == 10)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsstationessencedim"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}else if ((Math.floor(day) % 2)==0){
								if ((hour == 11 && minute == 10) || (hour == 13 && minute == 30)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lspiscinedim"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}else {
								if (
									(hour == 6 && minute == 11) || (hour == 6 && minute == 44) ||
									(hour == 7 && minute == 00) || (hour == 7 && minute == 15) || (hour == 7 && minute == 30) || (hour == 7 && minute == 45) ||
									(hour == 8 && minute == 00) || (hour == 8 && minute == 15) || (hour == 8 && minute == 30) || (hour == 8 && minute == 45) ||
									(hour == 11 && minute == 1) || (hour == 11 && minute == 9) || (hour == 11 && minute == 15) || (hour == 11 && minute == 21) || (hour == 11 && minute == 33) || (hour == 11 && minute == 41) || (hour == 11 && minute == 49) || (hour == 11 && minute == 55) ||
									(hour == 12 && minute == 1) || (hour == 12 && minute == 9) || (hour == 12 && minute == 15) || (hour == 12 && minute == 21) || (hour == 12 && minute == 33) || (hour == 12 && minute == 41) || (hour == 12 && minute == 49) || (hour == 12 && minute == 55) ||
									(hour == 13 && minute == 1) || (hour == 13 && minute == 9) || (hour == 13 && minute == 15) || (hour == 13 && minute == 21) || (hour == 13 && minute == 33) || (hour == 13 && minute == 41) || (hour == 13 && minute == 49) || (hour == 13 && minute == 55)
								) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lscentrecommercialdim"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}else if ((hour == 8 && minute == 10) || (hour == 8 && minute == 45) || (hour == 18 && minute == 45) || (hour == 18 && minute == 45)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbureaudim"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}else if ((hour == 22 && minute == 40) || (hour == 0 && minute == 28)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsbureauabandonedim"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
							
						}else if (shedule_id == 4) {
								if ((hour == 5 && minute == 40) || (hour == 17 && minute == 3)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lschampinfini"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
						}else if (shedule_id == 5) {
							if ((Math.floor(day) % 57)==0){
								if ((hour == 0 && minute == 0)) {
									if (le_joueur instanceof ServerPlayer _player && !_player.level().isClientSide()) {
										ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsoceandos"));
										if (_player.level().dimension() == destinationType)
											return;
										ServerLevel nextLevel = _player.server.getLevel(destinationType);
										if (nextLevel != null) {
											_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
											_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
											_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
											for (MobEffectInstance _effectinstance : _player.getActiveEffects())
												_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
											_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}