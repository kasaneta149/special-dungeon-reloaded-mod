package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D44Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD44Model;

public class D44Renderer extends MobRenderer<D44Entity, ModelD44Model<D44Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d44.png");

	public D44Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD44Model<D44Entity>(context.bakeLayer(ModelD44Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D44Entity entity) {
		if (entity.getTexture() != "d44")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}