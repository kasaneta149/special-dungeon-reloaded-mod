package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D27Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD27Model;

public class D27Renderer extends MobRenderer<D27Entity, ModelD27Model<D27Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d27.png");

	public D27Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD27Model<D27Entity>(context.bakeLayer(ModelD27Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D27Entity entity) {
		if (entity.getTexture() != "d27")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}