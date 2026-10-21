package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D45fEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD45Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class D45fRenderer extends MobRenderer<D45fEntity, ModelD45Model<D45fEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d45.png");

	public D45fRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD45Model<D45fEntity>(context.bakeLayer(ModelD45Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D45fEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.85f, 0.85f, 0.85f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(D45fEntity entity) {
		if (entity.getTexture() != "d45")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}