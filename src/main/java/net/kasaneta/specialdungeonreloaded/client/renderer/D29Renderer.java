package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D29Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD29Model;

public class D29Renderer extends MobRenderer<D29Entity, ModelD29Model<D29Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d29.png");

	public D29Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD29Model<D29Entity>(context.bakeLayer(ModelD29Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D29Entity entity) {
		if (entity.getTexture() != "d29")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}