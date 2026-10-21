package net.kasaneta.specialdungeonreloaded.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbus_chair<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("special_dungeon_reloaded", "modelbus_chair"), "main");
	public final ModelPart bone;

	public Modelbus_chair(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(12, 30).addBox(-13.0F, -11.0F, -8.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-13.0F, -26.0F, -8.0F, 26.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 30)
						.addBox(11.0F, -11.0F, -8.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 30).addBox(11.0F, -11.0F, 3.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 30)
						.addBox(-13.0F, -11.0F, 3.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-13.0F, -13.0F, -8.0F, 26.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(6, 30).addBox(24.0F, -17.0F, -1.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(49.0F, -17.0F, -1.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-37.0F, -12.0F, 4.0F, 0.6981F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}