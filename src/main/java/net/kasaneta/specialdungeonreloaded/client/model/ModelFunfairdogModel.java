package net.kasaneta.specialdungeonreloaded.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.HierarchicalModel;

public class ModelFunfairdogModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "model_funfairdog_model"), "main");
	public final ModelPart root;

	public ModelFunfairdogModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-315.0F, -1064.0F, -0.05F, 630.0F, 1064.0F, 0.1F), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 630, 1064);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		float baseScale = 0.032F;
		// Animation en 15 ticks (0.75s à 20 ticks/seconde)
		float cycleDuration = 15.0F;
		float normalizedTime = (ageInTicks % cycleDuration) / cycleDuration;
		float scaleX, scaleY;
		// Segment 1 : 0% → 10% (scaleX 1→1.03, scaleY 1→1)
		if (normalizedTime <= 0.1F) {
			float t = normalizedTime / 0.1F;
			float eased = (t < 0.5F) ? (2.0F * t * t) : (1.0F - (float) Math.pow(-2.0F * t + 2.0F, 2.0F) / 2.0F);
			scaleX = 1.0F + 0.03F * eased;
			scaleY = 1.0F;
		}
		// Segment 2 : 10% → 30% (scaleX 1.03→1, scaleY 1→1.04)
		else if (normalizedTime <= 0.3F) {
			float t = (normalizedTime - 0.1F) / 0.2F;
			float eased = (t < 0.5F) ? (2.0F * t * t) : (1.0F - (float) Math.pow(-2.0F * t + 2.0F, 2.0F) / 2.0F);
			scaleX = 1.03F - 0.03F * eased;
			scaleY = 1.0F + 0.04F * eased;
		}
		// Segment 3 : 30% → 100% (scaleX 1→1, scaleY 1.04→1)
		else {
			float t = (normalizedTime - 0.3F) / 0.7F;
			float eased = (t < 0.5F) ? (2.0F * t * t) : (1.0F - (float) Math.pow(-2.0F * t + 2.0F, 2.0F) / 2.0F);
			scaleX = 1.0F;
			scaleY = 1.04F - 0.04F * eased;
		}
		this.root.xScale = baseScale * scaleX;
		this.root.yScale = baseScale * scaleY;
		this.root.zScale = 1.0F;
	}
}