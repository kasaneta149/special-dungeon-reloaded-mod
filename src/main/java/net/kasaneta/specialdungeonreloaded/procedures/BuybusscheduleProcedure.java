package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModItems;

public class BuybusscheduleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randi = 0;
		if (entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money >= 5) {
			randi = Mth.nextInt(RandomSource.create(), 1, 7);
			{
				SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
				_vars.dungeon_money = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money - 5;
				_vars.markSyncDirty();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:coins_pickup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:coins_pickup")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (randi == 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_9.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 2) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_10.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_3.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 4) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_6.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 5) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_2.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 6) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_1.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}else if (randi == 7) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.BUSSHEDULE_7.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}