package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.kasaneta.specialdungeonreloaded.entity.BuschairEntity;
import net.kasaneta.specialdungeonreloaded.client.model.Modelbus_chair;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BuschairRenderer extends MobRenderer<BuschairEntity, Modelbus_chair<BuschairEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/buschair.png");

	public BuschairRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbus_chair<BuschairEntity>(context.bakeLayer(Modelbus_chair.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<BuschairEntity, Modelbus_chair<BuschairEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/buschair.png");
			final EntityModel LAYER_MODEL = new Modelbus_chair(Minecraft.getInstance().getEntityModels().bakeLayer(Modelbus_chair.LAYER_LOCATION));

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, BuschairEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().copyPropertiesTo(LAYER_MODEL);
				LAYER_MODEL.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				LAYER_MODEL.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				LAYER_MODEL.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
			}
		});
	}

	@Override
	protected void scale(BuschairEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.8f, 0.8f, 0.8f);
	}

	@Override
	public ResourceLocation getTextureLocation(BuschairEntity entity) {
		if (entity.getTexture() != "buschair")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}