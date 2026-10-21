package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D24Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD24Model;

public class D24Renderer extends MobRenderer<D24Entity, ModelD24Model<D24Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d24.png");

	public D24Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD24Model<D24Entity>(context.bakeLayer(ModelD24Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D24Entity entity) {
		if (entity.getTexture() != "d24")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}