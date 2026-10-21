package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D18Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD18Model;

public class D18Renderer extends MobRenderer<D18Entity, ModelD18Model<D18Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d18.png");

	public D18Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD18Model<D18Entity>(context.bakeLayer(ModelD18Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D18Entity entity) {
		if (entity.getTexture() != "d18")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}