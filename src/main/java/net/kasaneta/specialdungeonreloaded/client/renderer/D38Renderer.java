package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D38Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD38Model;

public class D38Renderer extends MobRenderer<D38Entity, ModelD38Model<D38Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d38.png");

	public D38Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD38Model<D38Entity>(context.bakeLayer(ModelD38Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D38Entity entity) {
		if (entity.getTexture() != "d38")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}