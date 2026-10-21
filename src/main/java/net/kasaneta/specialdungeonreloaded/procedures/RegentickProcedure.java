package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

import java.util.UUID;

public class RegentickProcedure {
	public static void execute(LevelAccessor world) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		Entity laval = null;
		if (Mth.nextInt(RandomSource.create(), 1, 45) == 20) {
			laval = world instanceof ServerLevel _level1 ? getEntityFromUUID(_level1, SpecialDungeonReloadedModVariables.WorldVariables.get(world).finalbossuuid) : null;
			if (laval != null) {
				if (laval instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1, false, false));
			}
		}
	}

	private static Entity getEntityFromUUID(ServerLevel level, String uuid) {
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}