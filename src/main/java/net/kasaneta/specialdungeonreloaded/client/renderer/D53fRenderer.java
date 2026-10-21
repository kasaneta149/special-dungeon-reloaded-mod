package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D53fEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD53Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class D53fRenderer extends MobRenderer<D53fEntity, ModelD53Model<D53fEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d53.png");

	public D53fRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD53Model<D53fEntity>(context.bakeLayer(ModelD53Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D53fEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.85f, 0.85f, 0.85f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(D53fEntity entity) {
		if (entity.getTexture() != "d53")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}