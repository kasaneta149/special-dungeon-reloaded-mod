package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D49Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD49Model;

public class D49Renderer extends MobRenderer<D49Entity, ModelD49Model<D49Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d49.png");

	public D49Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD49Model<D49Entity>(context.bakeLayer(ModelD49Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D49Entity entity) {
		if (entity.getTexture() != "d49")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}