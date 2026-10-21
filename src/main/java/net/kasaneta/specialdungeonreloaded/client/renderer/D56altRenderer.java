package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D56altEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD56Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class D56altRenderer extends MobRenderer<D56altEntity, ModelD56Model<D56altEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d56.png");

	public D56altRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD56Model<D56altEntity>(context.bakeLayer(ModelD56Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(D56altEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.8f, 0.8f, 0.8f);
	}

	@Override
	public ResourceLocation getTextureLocation(D56altEntity entity) {
		if (entity.getTexture() != "d56")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}