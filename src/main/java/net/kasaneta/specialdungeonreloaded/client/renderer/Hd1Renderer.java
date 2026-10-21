package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Hd1Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelHd1Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class Hd1Renderer extends MobRenderer<Hd1Entity, ModelHd1Model<Hd1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/hd1.png");

	public Hd1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelHd1Model<Hd1Entity>(context.bakeLayer(ModelHd1Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Hd1Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.35f, 2.35f, 2.35f);
	}

	@Override
	public ResourceLocation getTextureLocation(Hd1Entity entity) {
		if (entity.getTexture() != "hd1")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}