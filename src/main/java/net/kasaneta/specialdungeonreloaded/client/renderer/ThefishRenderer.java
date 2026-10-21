package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.ThefishEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelThefishModel;

public class ThefishRenderer extends MobRenderer<ThefishEntity, ModelThefishModel<ThefishEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/thefish.png");

	public ThefishRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelThefishModel<ThefishEntity>(context.bakeLayer(ModelThefishModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ThefishEntity entity) {
		if (entity.getTexture() != "thefish")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}