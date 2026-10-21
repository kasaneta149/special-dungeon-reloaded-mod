package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D4Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD4Model;

public class D4Renderer extends MobRenderer<D4Entity, ModelD4Model<D4Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d4.png");

	public D4Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD4Model<D4Entity>(context.bakeLayer(ModelD4Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D4Entity entity) {
		if (entity.getTexture() != "d4")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}