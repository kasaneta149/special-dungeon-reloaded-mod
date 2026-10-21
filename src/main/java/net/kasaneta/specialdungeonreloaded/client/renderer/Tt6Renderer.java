package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt6Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD42Model;

public class Tt6Renderer extends MobRenderer<Tt6Entity, ModelD42Model<Tt6Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d42.png");

	public Tt6Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD42Model<Tt6Entity>(context.bakeLayer(ModelD42Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt6Entity entity) {
		if (entity.getTexture() != "d42")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}