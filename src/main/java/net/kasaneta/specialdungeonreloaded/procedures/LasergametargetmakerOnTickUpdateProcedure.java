package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModEntities;

import java.util.UUID;

public class LasergametargetmakerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z))) {
			if (Mth.nextInt(RandomSource.create(), 1, 35) == 5) {
				if ((world instanceof ServerLevel _level3 ? getEntityFromUUID(_level3, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null) != null) {
					if (!(world instanceof ServerLevel _level5 ? getEntityFromUUID(_level5, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null).level().isClientSide())
						(world instanceof ServerLevel _level5 ? getEntityFromUUID(_level5, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null).discard();
				} else {
					if (Math.random() >= 0.95) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = SpecialDungeonReloadedModEntities.TARGET_1S.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = SpecialDungeonReloadedModEntities.TARGET_1.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static Entity getEntityFromUUID(ServerLevel level, String uuid) {
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}