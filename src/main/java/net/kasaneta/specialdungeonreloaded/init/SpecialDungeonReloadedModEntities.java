/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.kasaneta.specialdungeonreloaded.entity.*;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

@EventBusSubscriber
public class SpecialDungeonReloadedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SpecialDungeonReloadedMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<D1Entity>> D_1 = register("d_1", EntityType.Builder.<D1Entity>of(D1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.23f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D2Entity>> D_2 = register("d_2", EntityType.Builder.<D2Entity>of(D2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.16f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D3Entity>> D_3 = register("d_3", EntityType.Builder.<D3Entity>of(D3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.81f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D4Entity>> D_4 = register("d_4", EntityType.Builder.<D4Entity>of(D4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.27f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D5Entity>> D_5 = register("d_5", EntityType.Builder.<D5Entity>of(D5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.98f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D6Entity>> D_6 = register("d_6", EntityType.Builder.<D6Entity>of(D6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.09f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D7Entity>> D_7 = register("d_7", EntityType.Builder.<D7Entity>of(D7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.18f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D8Entity>> D_8 = register("d_8", EntityType.Builder.<D8Entity>of(D8Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.16f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D9Entity>> D_9 = register("d_9", EntityType.Builder.<D9Entity>of(D9Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.97f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D10Entity>> D_10 = register("d_10", EntityType.Builder.<D10Entity>of(D10Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.08f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D11Entity>> D_11 = register("d_11", EntityType.Builder.<D11Entity>of(D11Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.85f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D12Entity>> D_12 = register("d_12", EntityType.Builder.<D12Entity>of(D12Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.79f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D13Entity>> D_13 = register("d_13", EntityType.Builder.<D13Entity>of(D13Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.47f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D14Entity>> D_14 = register("d_14", EntityType.Builder.<D14Entity>of(D14Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.14f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D15Entity>> D_15 = register("d_15", EntityType.Builder.<D15Entity>of(D15Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.07f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D16Entity>> D_16 = register("d_16", EntityType.Builder.<D16Entity>of(D16Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.17f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D17Entity>> D_17 = register("d_17", EntityType.Builder.<D17Entity>of(D17Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.52f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D18Entity>> D_18 = register("d_18", EntityType.Builder.<D18Entity>of(D18Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.55f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D19Entity>> D_19 = register("d_19", EntityType.Builder.<D19Entity>of(D19Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.41f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D20Entity>> D_20 = register("d_20", EntityType.Builder.<D20Entity>of(D20Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.38f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D21Entity>> D_21 = register("d_21", EntityType.Builder.<D21Entity>of(D21Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.23f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D22Entity>> D_22 = register("d_22", EntityType.Builder.<D22Entity>of(D22Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.54f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D23Entity>> D_23 = register("d_23", EntityType.Builder.<D23Entity>of(D23Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.78f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D24Entity>> D_24 = register("d_24", EntityType.Builder.<D24Entity>of(D24Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.88f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D25Entity>> D_25 = register("d_25", EntityType.Builder.<D25Entity>of(D25Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D26Entity>> D_26 = register("d_26", EntityType.Builder.<D26Entity>of(D26Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.71f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D27Entity>> D_27 = register("d_27", EntityType.Builder.<D27Entity>of(D27Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.24f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D28Entity>> D_28 = register("d_28", EntityType.Builder.<D28Entity>of(D28Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.36f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D29Entity>> D_29 = register("d_29", EntityType.Builder.<D29Entity>of(D29Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.22f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D30Entity>> D_30 = register("d_30", EntityType.Builder.<D30Entity>of(D30Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.28f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D31Entity>> D_31 = register("d_31", EntityType.Builder.<D31Entity>of(D31Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.59f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D32Entity>> D_32 = register("d_32", EntityType.Builder.<D32Entity>of(D32Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.97f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D33Entity>> D_33 = register("d_33", EntityType.Builder.<D33Entity>of(D33Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D34Entity>> D_34 = register("d_34", EntityType.Builder.<D34Entity>of(D34Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.54f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D35Entity>> D_35 = register("d_35", EntityType.Builder.<D35Entity>of(D35Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.45f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D36Entity>> D_36 = register("d_36", EntityType.Builder.<D36Entity>of(D36Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.94f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D37Entity>> D_37 = register("d_37", EntityType.Builder.<D37Entity>of(D37Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.34f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D38Entity>> D_38 = register("d_38", EntityType.Builder.<D38Entity>of(D38Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.33f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D39Entity>> D_39 = register("d_39", EntityType.Builder.<D39Entity>of(D39Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.4f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D40Entity>> D_40 = register("d_40", EntityType.Builder.<D40Entity>of(D40Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.55f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuschairEntity>> BUSCHAIR = register("buschair",
			EntityType.Builder.<BuschairEntity>of(BuschairEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.4f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<D41Entity>> D_41 = register("d_41", EntityType.Builder.<D41Entity>of(D41Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.95f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D41BEntity>> D_41_B = register("d_41_b",
			EntityType.Builder.<D41BEntity>of(D41BEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.65f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D42Entity>> D_42 = register("d_42", EntityType.Builder.<D42Entity>of(D42Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.31f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D43Entity>> D_43 = register("d_43", EntityType.Builder.<D43Entity>of(D43Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.31f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D44Entity>> D_44 = register("d_44", EntityType.Builder.<D44Entity>of(D44Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.77f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D45Entity>> D_45 = register("d_45", EntityType.Builder.<D45Entity>of(D45Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D46Entity>> D_46 = register("d_46", EntityType.Builder.<D46Entity>of(D46Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.53f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D47Entity>> D_47 = register("d_47", EntityType.Builder.<D47Entity>of(D47Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D48Entity>> D_48 = register("d_48", EntityType.Builder.<D48Entity>of(D48Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.74f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D49Entity>> D_49 = register("d_49", EntityType.Builder.<D49Entity>of(D49Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.48f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D50Entity>> D_50 = register("d_50", EntityType.Builder.<D50Entity>of(D50Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.04f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D51Entity>> D_51 = register("d_51", EntityType.Builder.<D51Entity>of(D51Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.51f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D52Entity>> D_52 = register("d_52", EntityType.Builder.<D52Entity>of(D52Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.72f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D53Entity>> D_53 = register("d_53", EntityType.Builder.<D53Entity>of(D53Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.56f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D54Entity>> D_54 = register("d_54", EntityType.Builder.<D54Entity>of(D54Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.35f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Hd1Entity>> HD_1 = register("hd_1", EntityType.Builder.<Hd1Entity>of(Hd1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

			.sized(2.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Hd2Entity>> HD_2 = register("hd_2", EntityType.Builder.<Hd2Entity>of(Hd2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

			.sized(2.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Hd3Entity>> HD_3 = register("hd_3", EntityType.Builder.<Hd3Entity>of(Hd3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

			.sized(1.4f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Hd4Entity>> HD_4 = register("hd_4", EntityType.Builder.<Hd4Entity>of(Hd4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

			.sized(1.23f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D55Entity>> D_55 = register("d_55", EntityType.Builder.<D55Entity>of(D55Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.55f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D56Entity>> D_56 = register("d_56", EntityType.Builder.<D56Entity>of(D56Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.06f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D56altEntity>> D_56ALT = register("d_56alt",
			EntityType.Builder.<D56altEntity>of(D56altEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.86f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FinalbossEntity>> FINALBOSS = register("finalboss",
			EntityType.Builder.<FinalbossEntity>of(FinalbossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BossbulletEntity>> BOSSBULLET = register("bossbullet",
			EntityType.Builder.<BossbulletEntity>of(BossbulletEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<D57Entity>> D_57 = register("d_57", EntityType.Builder.<D57Entity>of(D57Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.11f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D58Entity>> D_58 = register("d_58", EntityType.Builder.<D58Entity>of(D58Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.27f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<RegendogEntity>> REGENDOG = register("regendog",
			EntityType.Builder.<RegendogEntity>of(RegendogEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3)

					.sized(1.38f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D46hardEntity>> D_46HARD = register("d_46hard",
			EntityType.Builder.<D46hardEntity>of(D46hardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.53f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Target1Entity>> TARGET_1 = register("target_1",
			EntityType.Builder.<Target1Entity>of(Target1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.53f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Target1sEntity>> TARGET_1S = register("target_1s",
			EntityType.Builder.<Target1sEntity>of(Target1sEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.53f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D46fEntity>> D_46F = register("d_46f",
			EntityType.Builder.<D46fEntity>of(D46fEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.53f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D45fEntity>> D_45F = register("d_45f",
			EntityType.Builder.<D45fEntity>of(D45fEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D47fEntity>> D_47F = register("d_47f",
			EntityType.Builder.<D47fEntity>of(D47fEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<D53fEntity>> D_53F = register("d_53f",
			EntityType.Builder.<D53fEntity>of(D53fEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.56f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt1Entity>> TT_1 = register("tt_1", EntityType.Builder.<Tt1Entity>of(Tt1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt2Entity>> TT_2 = register("tt_2", EntityType.Builder.<Tt2Entity>of(Tt2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.29f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt3Entity>> TT_3 = register("tt_3", EntityType.Builder.<Tt3Entity>of(Tt3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.94f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt4Entity>> TT_4 = register("tt_4", EntityType.Builder.<Tt4Entity>of(Tt4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.88f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt5Entity>> TT_5 = register("tt_5", EntityType.Builder.<Tt5Entity>of(Tt5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(2.41f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThefishEntity>> THEFISH = register("thefish",
			EntityType.Builder.<ThefishEntity>of(ThefishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(2.9f, 2.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Anomalie1Entity>> ANOMALIE_1 = register("anomalie_1",
			EntityType.Builder.<Anomalie1Entity>of(Anomalie1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Anomalie2Entity>> ANOMALIE_2 = register("anomalie_2",
			EntityType.Builder.<Anomalie2Entity>of(Anomalie2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Anomalie3Entity>> ANOMALIE_3 = register("anomalie_3",
			EntityType.Builder.<Anomalie3Entity>of(Anomalie3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Anomalie4Entity>> ANOMALIE_4 = register("anomalie_4",
			EntityType.Builder.<Anomalie4Entity>of(Anomalie4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<Tt6Entity>> TT_6 = register("tt_6", EntityType.Builder.<Tt6Entity>of(Tt6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1.31f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<LsthedirectorEntity>> LSTHEDIRECTOR = register("lsthedirector",
			EntityType.Builder.<LsthedirectorEntity>of(LsthedirectorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.81f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrazymanEntity>> CRAZYMAN = register("crazyman",
			EntityType.Builder.<CrazymanEntity>of(CrazymanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FunfairdogEntity>> FUNFAIRDOG = register("funfairdog",
			EntityType.Builder.<FunfairdogEntity>of(FunfairdogEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.98f, 0.9f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		D1Entity.init(event);
		D2Entity.init(event);
		D3Entity.init(event);
		D4Entity.init(event);
		D5Entity.init(event);
		D6Entity.init(event);
		D7Entity.init(event);
		D8Entity.init(event);
		D9Entity.init(event);
		D10Entity.init(event);
		D11Entity.init(event);
		D12Entity.init(event);
		D13Entity.init(event);
		D14Entity.init(event);
		D15Entity.init(event);
		D16Entity.init(event);
		D17Entity.init(event);
		D18Entity.init(event);
		D19Entity.init(event);
		D20Entity.init(event);
		D21Entity.init(event);
		D22Entity.init(event);
		D23Entity.init(event);
		D24Entity.init(event);
		D25Entity.init(event);
		D26Entity.init(event);
		D27Entity.init(event);
		D28Entity.init(event);
		D29Entity.init(event);
		D30Entity.init(event);
		D31Entity.init(event);
		D32Entity.init(event);
		D33Entity.init(event);
		D34Entity.init(event);
		D35Entity.init(event);
		D36Entity.init(event);
		D37Entity.init(event);
		D38Entity.init(event);
		D39Entity.init(event);
		D40Entity.init(event);
		BuschairEntity.init(event);
		D41Entity.init(event);
		D41BEntity.init(event);
		D42Entity.init(event);
		D43Entity.init(event);
		D44Entity.init(event);
		D45Entity.init(event);
		D46Entity.init(event);
		D47Entity.init(event);
		D48Entity.init(event);
		D49Entity.init(event);
		D50Entity.init(event);
		D51Entity.init(event);
		D52Entity.init(event);
		D53Entity.init(event);
		D54Entity.init(event);
		Hd1Entity.init(event);
		Hd2Entity.init(event);
		Hd3Entity.init(event);
		Hd4Entity.init(event);
		D55Entity.init(event);
		D56Entity.init(event);
		D56altEntity.init(event);
		FinalbossEntity.init(event);
		D57Entity.init(event);
		D58Entity.init(event);
		RegendogEntity.init(event);
		D46hardEntity.init(event);
		Target1Entity.init(event);
		Target1sEntity.init(event);
		D46fEntity.init(event);
		D45fEntity.init(event);
		D47fEntity.init(event);
		D53fEntity.init(event);
		Tt1Entity.init(event);
		Tt2Entity.init(event);
		Tt3Entity.init(event);
		Tt4Entity.init(event);
		Tt5Entity.init(event);
		ThefishEntity.init(event);
		Anomalie1Entity.init(event);
		Anomalie2Entity.init(event);
		Anomalie3Entity.init(event);
		Anomalie4Entity.init(event);
		Tt6Entity.init(event);
		LsthedirectorEntity.init(event);
		CrazymanEntity.init(event);
		FunfairdogEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(D_1.get(), D1Entity.createAttributes().build());
		event.put(D_2.get(), D2Entity.createAttributes().build());
		event.put(D_3.get(), D3Entity.createAttributes().build());
		event.put(D_4.get(), D4Entity.createAttributes().build());
		event.put(D_5.get(), D5Entity.createAttributes().build());
		event.put(D_6.get(), D6Entity.createAttributes().build());
		event.put(D_7.get(), D7Entity.createAttributes().build());
		event.put(D_8.get(), D8Entity.createAttributes().build());
		event.put(D_9.get(), D9Entity.createAttributes().build());
		event.put(D_10.get(), D10Entity.createAttributes().build());
		event.put(D_11.get(), D11Entity.createAttributes().build());
		event.put(D_12.get(), D12Entity.createAttributes().build());
		event.put(D_13.get(), D13Entity.createAttributes().build());
		event.put(D_14.get(), D14Entity.createAttributes().build());
		event.put(D_15.get(), D15Entity.createAttributes().build());
		event.put(D_16.get(), D16Entity.createAttributes().build());
		event.put(D_17.get(), D17Entity.createAttributes().build());
		event.put(D_18.get(), D18Entity.createAttributes().build());
		event.put(D_19.get(), D19Entity.createAttributes().build());
		event.put(D_20.get(), D20Entity.createAttributes().build());
		event.put(D_21.get(), D21Entity.createAttributes().build());
		event.put(D_22.get(), D22Entity.createAttributes().build());
		event.put(D_23.get(), D23Entity.createAttributes().build());
		event.put(D_24.get(), D24Entity.createAttributes().build());
		event.put(D_25.get(), D25Entity.createAttributes().build());
		event.put(D_26.get(), D26Entity.createAttributes().build());
		event.put(D_27.get(), D27Entity.createAttributes().build());
		event.put(D_28.get(), D28Entity.createAttributes().build());
		event.put(D_29.get(), D29Entity.createAttributes().build());
		event.put(D_30.get(), D30Entity.createAttributes().build());
		event.put(D_31.get(), D31Entity.createAttributes().build());
		event.put(D_32.get(), D32Entity.createAttributes().build());
		event.put(D_33.get(), D33Entity.createAttributes().build());
		event.put(D_34.get(), D34Entity.createAttributes().build());
		event.put(D_35.get(), D35Entity.createAttributes().build());
		event.put(D_36.get(), D36Entity.createAttributes().build());
		event.put(D_37.get(), D37Entity.createAttributes().build());
		event.put(D_38.get(), D38Entity.createAttributes().build());
		event.put(D_39.get(), D39Entity.createAttributes().build());
		event.put(D_40.get(), D40Entity.createAttributes().build());
		event.put(BUSCHAIR.get(), BuschairEntity.createAttributes().build());
		event.put(D_41.get(), D41Entity.createAttributes().build());
		event.put(D_41_B.get(), D41BEntity.createAttributes().build());
		event.put(D_42.get(), D42Entity.createAttributes().build());
		event.put(D_43.get(), D43Entity.createAttributes().build());
		event.put(D_44.get(), D44Entity.createAttributes().build());
		event.put(D_45.get(), D45Entity.createAttributes().build());
		event.put(D_46.get(), D46Entity.createAttributes().build());
		event.put(D_47.get(), D47Entity.createAttributes().build());
		event.put(D_48.get(), D48Entity.createAttributes().build());
		event.put(D_49.get(), D49Entity.createAttributes().build());
		event.put(D_50.get(), D50Entity.createAttributes().build());
		event.put(D_51.get(), D51Entity.createAttributes().build());
		event.put(D_52.get(), D52Entity.createAttributes().build());
		event.put(D_53.get(), D53Entity.createAttributes().build());
		event.put(D_54.get(), D54Entity.createAttributes().build());
		event.put(HD_1.get(), Hd1Entity.createAttributes().build());
		event.put(HD_2.get(), Hd2Entity.createAttributes().build());
		event.put(HD_3.get(), Hd3Entity.createAttributes().build());
		event.put(HD_4.get(), Hd4Entity.createAttributes().build());
		event.put(D_55.get(), D55Entity.createAttributes().build());
		event.put(D_56.get(), D56Entity.createAttributes().build());
		event.put(D_56ALT.get(), D56altEntity.createAttributes().build());
		event.put(FINALBOSS.get(), FinalbossEntity.createAttributes().build());
		event.put(D_57.get(), D57Entity.createAttributes().build());
		event.put(D_58.get(), D58Entity.createAttributes().build());
		event.put(REGENDOG.get(), RegendogEntity.createAttributes().build());
		event.put(D_46HARD.get(), D46hardEntity.createAttributes().build());
		event.put(TARGET_1.get(), Target1Entity.createAttributes().build());
		event.put(TARGET_1S.get(), Target1sEntity.createAttributes().build());
		event.put(D_46F.get(), D46fEntity.createAttributes().build());
		event.put(D_45F.get(), D45fEntity.createAttributes().build());
		event.put(D_47F.get(), D47fEntity.createAttributes().build());
		event.put(D_53F.get(), D53fEntity.createAttributes().build());
		event.put(TT_1.get(), Tt1Entity.createAttributes().build());
		event.put(TT_2.get(), Tt2Entity.createAttributes().build());
		event.put(TT_3.get(), Tt3Entity.createAttributes().build());
		event.put(TT_4.get(), Tt4Entity.createAttributes().build());
		event.put(TT_5.get(), Tt5Entity.createAttributes().build());
		event.put(THEFISH.get(), ThefishEntity.createAttributes().build());
		event.put(ANOMALIE_1.get(), Anomalie1Entity.createAttributes().build());
		event.put(ANOMALIE_2.get(), Anomalie2Entity.createAttributes().build());
		event.put(ANOMALIE_3.get(), Anomalie3Entity.createAttributes().build());
		event.put(ANOMALIE_4.get(), Anomalie4Entity.createAttributes().build());
		event.put(TT_6.get(), Tt6Entity.createAttributes().build());
		event.put(LSTHEDIRECTOR.get(), LsthedirectorEntity.createAttributes().build());
		event.put(CRAZYMAN.get(), CrazymanEntity.createAttributes().build());
		event.put(FUNFAIRDOG.get(), FunfairdogEntity.createAttributes().build());
	}
}