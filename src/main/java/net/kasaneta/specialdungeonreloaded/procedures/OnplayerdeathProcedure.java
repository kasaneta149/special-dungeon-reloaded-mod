package net.kasaneta.specialdungeonreloaded.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnplayerdeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
				_vars.blackout = false;
				_vars.dungeon_money = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money * 0.15;
				_vars.markSyncDirty();
			}
		}
	}
}