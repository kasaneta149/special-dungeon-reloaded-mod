package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.UUID;

public class LasergametargetmakerRedstoneOffProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity bount_ent = null;
		if ((world instanceof ServerLevel _level1 ? getEntityFromUUID(_level1, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null) != null) {
			if (!(world instanceof ServerLevel _level3 ? getEntityFromUUID(_level3, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null).level().isClientSide())
				(world instanceof ServerLevel _level3 ? getEntityFromUUID(_level3, (getBlockNBTString(world, BlockPos.containing(x, y, z), "bound_mob"))) : null).discard();
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