package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt2Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD47Model;

public class Tt2Renderer extends MobRenderer<Tt2Entity, ModelD47Model<Tt2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d47.png");

	public Tt2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD47Model<Tt2Entity>(context.bakeLayer(ModelD47Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt2Entity entity) {
		if (entity.getTexture() != "d47")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}