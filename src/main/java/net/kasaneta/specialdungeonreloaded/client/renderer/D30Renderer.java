package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D30Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD30Model;

public class D30Renderer extends MobRenderer<D30Entity, ModelD30Model<D30Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d30.png");

	public D30Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD30Model<D30Entity>(context.bakeLayer(ModelD30Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D30Entity entity) {
		if (entity.getTexture() != "d30")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}