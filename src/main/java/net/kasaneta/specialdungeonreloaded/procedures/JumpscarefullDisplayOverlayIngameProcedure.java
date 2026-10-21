package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;

public class JumpscarefullDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SpecialDungeonReloadedModMobEffects.NOTCARREFUL);
	}
}