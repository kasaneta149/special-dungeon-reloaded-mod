package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D10Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD10Model;

public class D10Renderer extends MobRenderer<D10Entity, ModelD10Model<D10Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d10.png");

	public D10Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD10Model<D10Entity>(context.bakeLayer(ModelD10Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D10Entity entity) {
		if (entity.getTexture() != "d10")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}