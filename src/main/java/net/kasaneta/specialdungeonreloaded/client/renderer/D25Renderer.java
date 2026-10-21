package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D25Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD25Model;

public class D25Renderer extends MobRenderer<D25Entity, ModelD25Model<D25Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d25.png");

	public D25Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD25Model<D25Entity>(context.bakeLayer(ModelD25Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D25Entity entity) {
		if (entity.getTexture() != "d25")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}