package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt3Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD36Model;

public class Tt3Renderer extends MobRenderer<Tt3Entity, ModelD36Model<Tt3Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d36.png");

	public Tt3Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD36Model<Tt3Entity>(context.bakeLayer(ModelD36Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt3Entity entity) {
		if (entity.getTexture() != "d36")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}