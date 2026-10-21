package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D41Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD41Model;

public class D41Renderer extends MobRenderer<D41Entity, ModelD41Model<D41Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d41.png");

	public D41Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD41Model<D41Entity>(context.bakeLayer(ModelD41Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D41Entity entity) {
		if (entity.getTexture() != "d41")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}