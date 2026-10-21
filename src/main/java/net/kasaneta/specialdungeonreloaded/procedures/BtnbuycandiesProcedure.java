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

public class BtnbuycandiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randi = 0;
		if (entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money >= 2.5) {
			randi = Mth.nextInt(RandomSource.create(), 1, 27);
			{
				SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
				_vars.dungeon_money = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money - 2.5;
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
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_1.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 2) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_2.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 3) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_3.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 4) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_4.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 5) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_5.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 6) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_6.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 7) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_7.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 8) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_8.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 9) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_9.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 10) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_10.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 11) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_11.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 12) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_12.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 13) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_13.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 14) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_14.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 15) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_15.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 16) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_16.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 17) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_17.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 18) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_18.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 19) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_19.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 20) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_20.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 21) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_21.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 22) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_22.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 23) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_23.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 24) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_24.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 25) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_25.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 26) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_26.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (randi == 27) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SpecialDungeonReloadedModItems.CANDY_27.get()));
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}