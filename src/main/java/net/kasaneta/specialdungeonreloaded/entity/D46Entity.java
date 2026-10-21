package net.kasaneta.specialdungeonreloaded.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.kasaneta.specialdungeonreloaded.procedures.IsAgreesiveProcedure;

import java.util.EnumSet;

public class D46Entity extends Monster {
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(D46Entity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> ANIM = SynchedEntityData.defineId(D46Entity.class, EntityDataSerializers.INT);

	public D46Entity(EntityType<D46Entity> type, Level world) {
		super(type, world);
		xpReward = 75;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(TEXTURE, "d46");
		builder.define(ANIM, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2) {
			@Override
			public boolean canUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canUse() && IsAgreesiveProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canContinueToUse() && IsAgreesiveProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (D46Entity.this.getTarget() != null && !D46Entity.this.getMoveControl().hasWanted()) {
					double x = D46Entity.this.getX();
					double y = D46Entity.this.getY();
					double z = D46Entity.this.getZ();
					Entity entity = D46Entity.this;
					Level world = D46Entity.this.level();
					return IsAgreesiveProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return IsAgreesiveProcedure.execute(entity) && D46Entity.this.getMoveControl().hasWanted() && D46Entity.this.getTarget() != null && D46Entity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = D46Entity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				D46Entity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = D46Entity.this.getTarget();
				if (D46Entity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					D46Entity.this.doHurtTarget(livingentity);
				} else {
					double d0 = D46Entity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						D46Entity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = D46Entity.this.getRandom();
				double dir_x = D46Entity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = D46Entity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = D46Entity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canUse() && IsAgreesiveProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canContinueToUse() && IsAgreesiveProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, (float) 6) {
			@Override
			public boolean canUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canUse() && IsAgreesiveProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canContinueToUse() && IsAgreesiveProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canUse() && IsAgreesiveProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canContinueToUse() && IsAgreesiveProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(9, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canUse() && IsAgreesiveProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = D46Entity.this.getX();
				double y = D46Entity.this.getY();
				double z = D46Entity.this.getZ();
				Entity entity = D46Entity.this;
				Level world = D46Entity.this.level();
				return super.canContinueToUse() && IsAgreesiveProcedure.execute(entity);
			}
		});
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}