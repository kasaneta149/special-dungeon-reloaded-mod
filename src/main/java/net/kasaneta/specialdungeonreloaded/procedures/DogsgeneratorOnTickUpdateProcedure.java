package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModEntities;

public class DogsgeneratorOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double fr = 0;
		fr = Mth.nextInt(RandomSource.create(), 1, 7);
		if (fr == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_1.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_2.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_3.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 4) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_6.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 5) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_7.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 6) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_11.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		} else if (fr == 7) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SpecialDungeonReloadedModEntities.D_15.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}