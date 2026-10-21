package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D14Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD14Model;

public class D14Renderer extends MobRenderer<D14Entity, ModelD14Model<D14Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d14.png");

	public D14Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD14Model<D14Entity>(context.bakeLayer(ModelD14Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D14Entity entity) {
		if (entity.getTexture() != "d14")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}