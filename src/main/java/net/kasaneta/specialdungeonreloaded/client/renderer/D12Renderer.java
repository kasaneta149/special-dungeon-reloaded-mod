package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D12Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD12Model;

public class D12Renderer extends MobRenderer<D12Entity, ModelD12Model<D12Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d12.png");

	public D12Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD12Model<D12Entity>(context.bakeLayer(ModelD12Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D12Entity entity) {
		if (entity.getTexture() != "d12")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}