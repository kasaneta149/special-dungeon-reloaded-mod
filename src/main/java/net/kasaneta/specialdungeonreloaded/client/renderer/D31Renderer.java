package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D31Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD31Model;

public class D31Renderer extends MobRenderer<D31Entity, ModelD31Model<D31Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d31.png");

	public D31Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD31Model<D31Entity>(context.bakeLayer(ModelD31Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D31Entity entity) {
		if (entity.getTexture() != "d31")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}