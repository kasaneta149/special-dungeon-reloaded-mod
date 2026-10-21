package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D13Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD13Model;

public class D13Renderer extends MobRenderer<D13Entity, ModelD13Model<D13Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d13.png");

	public D13Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD13Model<D13Entity>(context.bakeLayer(ModelD13Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D13Entity entity) {
		if (entity.getTexture() != "d13")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}