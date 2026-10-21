package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D56Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD56Model;

public class D56Renderer extends MobRenderer<D56Entity, ModelD56Model<D56Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d56.png");

	public D56Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD56Model<D56Entity>(context.bakeLayer(ModelD56Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D56Entity entity) {
		if (entity.getTexture() != "d56")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}