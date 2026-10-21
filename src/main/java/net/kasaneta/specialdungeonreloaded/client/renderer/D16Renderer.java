package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D16Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD16Model;

public class D16Renderer extends MobRenderer<D16Entity, ModelD16Model<D16Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d16.png");

	public D16Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD16Model<D16Entity>(context.bakeLayer(ModelD16Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D16Entity entity) {
		if (entity.getTexture() != "d16")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}