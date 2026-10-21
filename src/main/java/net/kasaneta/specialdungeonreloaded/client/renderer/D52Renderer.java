package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D52Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD52Model;

public class D52Renderer extends MobRenderer<D52Entity, ModelD52Model<D52Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d52.png");

	public D52Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD52Model<D52Entity>(context.bakeLayer(ModelD52Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D52Entity entity) {
		if (entity.getTexture() != "d52")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}