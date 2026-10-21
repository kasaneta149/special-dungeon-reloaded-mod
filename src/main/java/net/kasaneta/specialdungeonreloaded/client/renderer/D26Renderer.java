package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D26Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD26Model;

public class D26Renderer extends MobRenderer<D26Entity, ModelD26Model<D26Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d26.png");

	public D26Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD26Model<D26Entity>(context.bakeLayer(ModelD26Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D26Entity entity) {
		if (entity.getTexture() != "d26")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}