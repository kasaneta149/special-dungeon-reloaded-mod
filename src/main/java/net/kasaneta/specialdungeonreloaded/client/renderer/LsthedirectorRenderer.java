package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.LsthedirectorEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD26Model;

public class LsthedirectorRenderer extends MobRenderer<LsthedirectorEntity, ModelD26Model<LsthedirectorEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d26.png");

	public LsthedirectorRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelD26Model<LsthedirectorEntity>(context.bakeLayer(ModelD26Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LsthedirectorEntity entity) {
		if (entity.getTexture() != "d26")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}