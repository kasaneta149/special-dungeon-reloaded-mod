package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.FunfairdogEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelFunfairdogModel;

public class FunfairdogRenderer extends MobRenderer<FunfairdogEntity, ModelFunfairdogModel<FunfairdogEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/funfairdog.png");

	public FunfairdogRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFunfairdogModel<FunfairdogEntity>(context.bakeLayer(ModelFunfairdogModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FunfairdogEntity entity) {
		if (entity.getTexture() != "funfairdog")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}