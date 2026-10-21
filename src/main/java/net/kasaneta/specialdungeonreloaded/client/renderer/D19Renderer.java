package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D19Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD19Model;

public class D19Renderer extends MobRenderer<D19Entity, ModelD19Model<D19Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d19.png");

	public D19Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD19Model<D19Entity>(context.bakeLayer(ModelD19Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D19Entity entity) {
		if (entity.getTexture() != "d19")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}