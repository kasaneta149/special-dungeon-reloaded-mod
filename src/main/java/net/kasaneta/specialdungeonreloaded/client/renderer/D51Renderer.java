package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D51Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD51Model;

public class D51Renderer extends MobRenderer<D51Entity, ModelD51Model<D51Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d51.png");

	public D51Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD51Model<D51Entity>(context.bakeLayer(ModelD51Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D51Entity entity) {
		if (entity.getTexture() != "d51")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}