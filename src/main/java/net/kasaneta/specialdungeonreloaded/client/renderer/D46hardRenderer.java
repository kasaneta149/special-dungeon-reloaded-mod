package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D46hardEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD46Model;

public class D46hardRenderer extends MobRenderer<D46hardEntity, ModelD46Model<D46hardEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d46hardened.png");

	public D46hardRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD46Model<D46hardEntity>(context.bakeLayer(ModelD46Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D46hardEntity entity) {
		if (entity.getTexture() != "d46hardened")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}