package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D3Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD3Model;

public class D3Renderer extends MobRenderer<D3Entity, ModelD3Model<D3Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d3.png");

	public D3Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD3Model<D3Entity>(context.bakeLayer(ModelD3Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D3Entity entity) {
		if (entity.getTexture() != "d3")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}