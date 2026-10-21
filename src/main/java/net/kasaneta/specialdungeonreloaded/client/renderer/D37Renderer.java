package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D37Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD37Model;

public class D37Renderer extends MobRenderer<D37Entity, ModelD37Model<D37Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d37.png");

	public D37Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD37Model<D37Entity>(context.bakeLayer(ModelD37Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D37Entity entity) {
		if (entity.getTexture() != "d37")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}