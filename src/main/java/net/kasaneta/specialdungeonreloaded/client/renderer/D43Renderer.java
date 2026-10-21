package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D43Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD43Model;

public class D43Renderer extends MobRenderer<D43Entity, ModelD43Model<D43Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d43.png");

	public D43Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD43Model<D43Entity>(context.bakeLayer(ModelD43Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D43Entity entity) {
		if (entity.getTexture() != "d43")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}