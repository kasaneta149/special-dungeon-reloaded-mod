package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D32Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD32Model;

public class D32Renderer extends MobRenderer<D32Entity, ModelD32Model<D32Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d32.png");

	public D32Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD32Model<D32Entity>(context.bakeLayer(ModelD32Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D32Entity entity) {
		if (entity.getTexture() != "d32")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}