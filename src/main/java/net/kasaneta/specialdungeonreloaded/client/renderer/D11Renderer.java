package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D11Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD11Model;

public class D11Renderer extends MobRenderer<D11Entity, ModelD11Model<D11Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d11.png");

	public D11Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD11Model<D11Entity>(context.bakeLayer(ModelD11Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D11Entity entity) {
		if (entity.getTexture() != "d11")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}