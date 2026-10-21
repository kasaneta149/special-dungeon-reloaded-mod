package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Hd3Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelHd3Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class Hd3Renderer extends MobRenderer<Hd3Entity, ModelHd3Model<Hd3Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/hd3.png");

	public Hd3Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelHd3Model<Hd3Entity>(context.bakeLayer(ModelHd3Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Hd3Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.35f, 2.35f, 2.35f);
	}

	@Override
	public ResourceLocation getTextureLocation(Hd3Entity entity) {
		if (entity.getTexture() != "hd3")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}