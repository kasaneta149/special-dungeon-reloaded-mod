package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D58Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD58Model;

public class D58Renderer extends MobRenderer<D58Entity, ModelD58Model<D58Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d58.png");

	public D58Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD58Model<D58Entity>(context.bakeLayer(ModelD58Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D58Entity entity) {
		if (entity.getTexture() != "d58")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}