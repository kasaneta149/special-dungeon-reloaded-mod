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

public class ModelD41BlueModel<T extends Entity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "model_d_41_blue_model"), "main");
	public final ModelPart root;

	public ModelD41BlueModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-214.5F, -291.0F, -0.05F, 429.0F, 291.0F, 0.1F), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 429, 291);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		float baseScale = 0.10996563573883161F;
		float time = ageInTicks * (float) Math.PI / 10.0F;
		this.root.xScale = baseScale * (1.05F + 0.05F * (float) Math.cos(time));
		this.root.yScale = baseScale * (1.00F - 0.10F * (float) Math.cos(time));
		this.root.zScale = 1.00F;
	}
}