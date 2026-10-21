package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Hd4Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelHd4Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class Hd4Renderer extends MobRenderer<Hd4Entity, ModelHd4Model<Hd4Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/hd4.png");

	public Hd4Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelHd4Model<Hd4Entity>(context.bakeLayer(ModelHd4Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Hd4Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.35f, 2.35f, 2.35f);
	}

	@Override
	public ResourceLocation getTextureLocation(Hd4Entity entity) {
		if (entity.getTexture() != "hd4")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}