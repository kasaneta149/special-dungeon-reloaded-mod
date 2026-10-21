package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D7Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD7Model;

public class D7Renderer extends MobRenderer<D7Entity, ModelD7Model<D7Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d7.png");

	public D7Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD7Model<D7Entity>(context.bakeLayer(ModelD7Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D7Entity entity) {
		if (entity.getTexture() != "d7")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}