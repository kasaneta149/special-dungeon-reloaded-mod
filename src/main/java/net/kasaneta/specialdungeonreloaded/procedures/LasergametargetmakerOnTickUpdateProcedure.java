package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModEntities;

public class LasergametargetmakerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof ServerLevel level))
			return;
		RandomSource random = level.getRandom();
		if (random.nextInt(35) != 0)
			return;
		BlockPos pos = BlockPos.containing(x, y, z);
		if (!level.hasNeighborSignal(pos))
			return;
		Entity target = LaserGame.getBoundTarget(level, pos);
		if (target != null) {
			target.discard();
			return;
		}
		EntityType<?> type = random.nextDouble() >= 0.95 ? SpecialDungeonReloadedModEntities.TARGET_1S.get() : SpecialDungeonReloadedModEntities.TARGET_1.get();
		Entity spawned = type.spawn(level, pos.above(), MobSpawnType.MOB_SUMMONED);
		if (spawned != null) {
			spawned.setDeltaMovement(0, 0, 0);
			LaserGame.setBoundTarget(level, pos, spawned.getStringUUID());
		}
	}
}