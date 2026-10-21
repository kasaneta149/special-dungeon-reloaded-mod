package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.kasaneta.specialdungeonreloaded.entity.FinalbossEntity;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class FinalbossEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null) return false;
		double ennemy_health = ((double) (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 100;

		if (ennemy_health >= 95) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg17");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg18");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg17");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg18");
					});
				});
			});
		} else if (ennemy_health >= 90) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg16");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg17");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg16");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg17");
					});
				});
			});
		} else if (ennemy_health >= 85) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg15");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg16");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg15");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg16");
					});
				});
			});
		} else if (ennemy_health >= 80) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg14");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg15");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg14");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg15");
					});
				});
			});
		} else if (ennemy_health >= 75) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg13");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg14");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg13");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg14");
					});
				});
			});
		} else if (ennemy_health >= 70) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg12");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg13");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg12");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg13");
					});
				});
			});
		} else if (ennemy_health >= 65) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg11");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg12");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg11");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg12");
					});
				});
			});
		} else if (ennemy_health >= 60) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg10");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg11");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg10");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg11");
					});
				});
			});
		} else if (ennemy_health >= 55) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg9");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg10");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg9");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg10");
					});
				});
			});
		} else if (ennemy_health >= 50) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg8");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg9");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg8");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg9");
					});
				});
			});
		} else if (ennemy_health >= 45) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg7");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg8");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg7");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg8");
					});
				});
			});
		} else if (ennemy_health >= 40) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg6");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg5");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg6");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg5");
					});
				});
			});
		} else if (ennemy_health >= 35) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg5");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg4");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg5");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg4");
					});
				});
			});
		} else if (ennemy_health >= 30) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg4");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg5");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg4");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg5");
					});
				});
			});
		} else if (ennemy_health >= 25) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg3");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg4");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg3");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg4");
					});
				});
			});
		} else if (ennemy_health >= 20) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg2");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg3");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg2");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg3");
					});
				});
			});
		} else if (ennemy_health >= 15) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg1");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg2");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg1");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg2");
					});
				});
			});
		} else if (ennemy_health >= 7.5) {
			if (entity instanceof FinalbossEntity customEntity)
				customEntity.setTexture("finalbossimg1_");
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				if (entity instanceof FinalbossEntity customEntity)
					customEntity.setTexture("finalbossimg1");
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					if (entity instanceof FinalbossEntity customEntity)
						customEntity.setTexture("finalbossimg1_");
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						if (entity instanceof FinalbossEntity customEntity)
							customEntity.setTexture("finalbossimg1");
					});
				});
			});
		} else {
			if (entity instanceof FinalbossEntity customEntity) customEntity.setTexture("finalbossimg1");
			entity.setInvisible(true);
			SpecialDungeonReloadedMod.queueServerWork(2, () -> {
				entity.setInvisible(false);
				SpecialDungeonReloadedMod.queueServerWork(2, () -> {
					entity.setInvisible(true);
					SpecialDungeonReloadedMod.queueServerWork(2, () -> {
						entity.setInvisible(false);
					});
				});
			});
		}
		return true;
	}
}