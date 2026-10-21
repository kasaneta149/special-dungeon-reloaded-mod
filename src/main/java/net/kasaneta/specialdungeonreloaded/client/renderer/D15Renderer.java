package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D15Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD15Model;

public class D15Renderer extends MobRenderer<D15Entity, ModelD15Model<D15Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d15.png");

	public D15Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD15Model<D15Entity>(context.bakeLayer(ModelD15Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D15Entity entity) {
		if (entity.getTexture() != "d15")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}