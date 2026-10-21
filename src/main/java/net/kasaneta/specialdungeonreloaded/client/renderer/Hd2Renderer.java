package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Hd2Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelHd2Model;

import com.mojang.blaze3d.vertex.PoseStack;

public class Hd2Renderer extends MobRenderer<Hd2Entity, ModelHd2Model<Hd2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/hd2.png");

	public Hd2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelHd2Model<Hd2Entity>(context.bakeLayer(ModelHd2Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(Hd2Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.35f, 2.35f, 2.35f);
	}

	@Override
	public ResourceLocation getTextureLocation(Hd2Entity entity) {
		if (entity.getTexture() != "hd2")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}