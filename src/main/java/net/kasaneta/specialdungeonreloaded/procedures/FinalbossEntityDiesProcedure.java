package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModItems;

public class FinalbossEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).final_dead = true;
		SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 2), z, new ItemStack(SpecialDungeonReloadedModItems.BEDROCKDESTROYER.get()));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}