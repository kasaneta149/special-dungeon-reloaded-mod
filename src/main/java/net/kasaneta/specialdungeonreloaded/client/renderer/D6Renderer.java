package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D6Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD6Model;

public class D6Renderer extends MobRenderer<D6Entity, ModelD6Model<D6Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d6.png");

	public D6Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD6Model<D6Entity>(context.bakeLayer(ModelD6Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D6Entity entity) {
		if (entity.getTexture() != "d6")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}