package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D36Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD36Model;

public class D36Renderer extends MobRenderer<D36Entity, ModelD36Model<D36Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d36.png");

	public D36Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD36Model<D36Entity>(context.bakeLayer(ModelD36Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D36Entity entity) {
		if (entity.getTexture() != "d36")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}