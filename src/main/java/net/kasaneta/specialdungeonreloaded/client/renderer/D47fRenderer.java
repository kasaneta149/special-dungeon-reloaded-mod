package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D47fEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD47Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class D47fRenderer extends MobRenderer<D47fEntity, ModelD47Model<D47fEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d47.png");

	public D47fRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD47Model<D47fEntity>(context.bakeLayer(ModelD47Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D47fEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.85f, 0.85f, 0.85f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(D47fEntity entity) {
		if (entity.getTexture() != "d47")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}