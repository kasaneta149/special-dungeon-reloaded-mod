package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D17Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD17Model;

public class D17Renderer extends MobRenderer<D17Entity, ModelD17Model<D17Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d17.png");

	public D17Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD17Model<D17Entity>(context.bakeLayer(ModelD17Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D17Entity entity) {
		if (entity.getTexture() != "d17")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}