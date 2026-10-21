package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D57Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD57Model;

public class D57Renderer extends MobRenderer<D57Entity, ModelD57Model<D57Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d57.png");

	public D57Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD57Model<D57Entity>(context.bakeLayer(ModelD57Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D57Entity entity) {
		if (entity.getTexture() != "d57")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}