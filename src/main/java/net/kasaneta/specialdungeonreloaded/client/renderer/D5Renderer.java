package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D5Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD5Model;

public class D5Renderer extends MobRenderer<D5Entity, ModelD5Model<D5Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d5.png");

	public D5Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD5Model<D5Entity>(context.bakeLayer(ModelD5Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D5Entity entity) {
		if (entity.getTexture() != "d5")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}