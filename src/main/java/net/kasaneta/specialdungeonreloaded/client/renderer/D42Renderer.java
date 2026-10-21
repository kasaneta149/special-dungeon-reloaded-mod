package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D42Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD42Model;

public class D42Renderer extends MobRenderer<D42Entity, ModelD42Model<D42Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d42.png");

	public D42Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD42Model<D42Entity>(context.bakeLayer(ModelD42Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D42Entity entity) {
		if (entity.getTexture() != "d42")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}