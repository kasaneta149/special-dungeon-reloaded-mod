package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D8Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD8Model;

public class D8Renderer extends MobRenderer<D8Entity, ModelD8Model<D8Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d8.png");

	public D8Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD8Model<D8Entity>(context.bakeLayer(ModelD8Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D8Entity entity) {
		if (entity.getTexture() != "d8")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}