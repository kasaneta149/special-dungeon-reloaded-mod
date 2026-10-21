package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D39Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD39Model;

public class D39Renderer extends MobRenderer<D39Entity, ModelD39Model<D39Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d39.png");

	public D39Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD39Model<D39Entity>(context.bakeLayer(ModelD39Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D39Entity entity) {
		if (entity.getTexture() != "d39")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}