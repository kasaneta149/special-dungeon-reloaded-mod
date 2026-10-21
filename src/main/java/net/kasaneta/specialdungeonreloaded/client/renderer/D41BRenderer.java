package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D41BEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD41BlueModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class D41BRenderer extends MobRenderer<D41BEntity, ModelD41BlueModel<D41BEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d41_blue.png");

	public D41BRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD41BlueModel<D41BEntity>(context.bakeLayer(ModelD41BlueModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D41BEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(D41BEntity entity) {
		if (entity.getTexture() != "d41_blue")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}