package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D48Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD48Model;

public class D48Renderer extends MobRenderer<D48Entity, ModelD48Model<D48Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d48.png");

	public D48Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD48Model<D48Entity>(context.bakeLayer(ModelD48Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D48Entity entity) {
		if (entity.getTexture() != "d48")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}