package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D22Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD22Model;

public class D22Renderer extends MobRenderer<D22Entity, ModelD22Model<D22Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d22.png");

	public D22Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD22Model<D22Entity>(context.bakeLayer(ModelD22Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D22Entity entity) {
		if (entity.getTexture() != "d22")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}