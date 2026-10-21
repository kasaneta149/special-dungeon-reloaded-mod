package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class IsinbuildingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:building"));
	}
}