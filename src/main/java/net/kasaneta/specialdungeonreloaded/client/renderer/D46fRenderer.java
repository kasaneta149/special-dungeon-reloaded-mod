package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D46fEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD46Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class D46fRenderer extends MobRenderer<D46fEntity, ModelD46Model<D46fEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d46.png");

	public D46fRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD46Model<D46fEntity>(context.bakeLayer(ModelD46Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D46fEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.85f, 0.85f, 0.85f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(D46fEntity entity) {
		if (entity.getTexture() != "d46")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}