package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;
import net.kasaneta.specialdungeonreloaded.entity.Hd4Entity;
import net.kasaneta.specialdungeonreloaded.entity.Hd3Entity;
import net.kasaneta.specialdungeonreloaded.entity.Hd2Entity;
import net.kasaneta.specialdungeonreloaded.entity.Hd1Entity;

public class HearthdestroyedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Hd1Entity) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).h1_destroyed = true;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		} else if (entity instanceof Hd2Entity) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).h2_destroyed = true;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		} else if (entity instanceof Hd3Entity) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).h3_destroyed = true;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		} else if (entity instanceof Hd4Entity) {
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).h4_destroyed = true;
			SpecialDungeonReloadedModVariables.WorldVariables.get(world).markSyncDirty();
		}
	}
}