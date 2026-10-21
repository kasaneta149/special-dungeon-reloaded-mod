package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D54Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD54Model;

public class D54Renderer extends MobRenderer<D54Entity, ModelD54Model<D54Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d54.png");

	public D54Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD54Model<D54Entity>(context.bakeLayer(ModelD54Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D54Entity entity) {
		if (entity.getTexture() != "d54")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}