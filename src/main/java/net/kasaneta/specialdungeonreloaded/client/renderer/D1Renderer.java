package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D1Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD1Model;

public class D1Renderer extends MobRenderer<D1Entity, ModelD1Model<D1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d1.png");

	public D1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD1Model<D1Entity>(context.bakeLayer(ModelD1Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D1Entity entity) {
		if (entity.getTexture() != "d1")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}