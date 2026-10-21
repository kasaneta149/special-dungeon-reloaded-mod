package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class BlackdespawnEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 99999999);
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}