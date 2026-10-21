package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D9Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD9Model;

public class D9Renderer extends MobRenderer<D9Entity, ModelD9Model<D9Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d9.png");

	public D9Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD9Model<D9Entity>(context.bakeLayer(ModelD9Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D9Entity entity) {
		if (entity.getTexture() != "d9")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}