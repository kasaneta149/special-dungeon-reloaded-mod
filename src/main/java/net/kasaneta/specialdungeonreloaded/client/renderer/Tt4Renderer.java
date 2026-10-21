package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt4Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD24Model;

public class Tt4Renderer extends MobRenderer<Tt4Entity, ModelD24Model<Tt4Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d24.png");

	public Tt4Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD24Model<Tt4Entity>(context.bakeLayer(ModelD24Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt4Entity entity) {
		if (entity.getTexture() != "d24")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}