package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D33Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD33Model;

public class D33Renderer extends MobRenderer<D33Entity, ModelD33Model<D33Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d33.png");

	public D33Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD33Model<D33Entity>(context.bakeLayer(ModelD33Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D33Entity entity) {
		if (entity.getTexture() != "d33")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}