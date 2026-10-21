package net.kasaneta.specialdungeonreloaded.world.dimension;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.kasaneta.specialdungeonreloaded.procedures.LsvilleinfiniePlayerEntersDimensionProcedure;

@EventBusSubscriber
public class LsvilleinfinieDimension {
	@SubscribeEvent
	public static void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getEntity();
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (event.getTo() == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("special_dungeon_reloaded:lsvilleinfinie"))) {
			LsvilleinfiniePlayerEntersDimensionProcedure.execute(world, entity);
		}
	}
}