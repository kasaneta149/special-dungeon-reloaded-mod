package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Target1Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD46Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class Target1Renderer extends MobRenderer<Target1Entity, ModelD46Model<Target1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d46.png");

	public Target1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD46Model<Target1Entity>(context.bakeLayer(ModelD46Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Target1Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.7f, 0.7f, 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(Target1Entity entity) {
		if (entity.getTexture() != "d46")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}