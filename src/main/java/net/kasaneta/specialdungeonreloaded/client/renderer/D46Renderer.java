package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D46Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD46Model;

public class D46Renderer extends MobRenderer<D46Entity, ModelD46Model<D46Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d46.png");

	public D46Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD46Model<D46Entity>(context.bakeLayer(ModelD46Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D46Entity entity) {
		if (entity.getTexture() != "d46")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}