package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D21Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD21Model;

public class D21Renderer extends MobRenderer<D21Entity, ModelD21Model<D21Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d21.png");

	public D21Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD21Model<D21Entity>(context.bakeLayer(ModelD21Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D21Entity entity) {
		if (entity.getTexture() != "d21")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}