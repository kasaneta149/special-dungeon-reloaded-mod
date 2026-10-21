package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D34Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD34Model;

public class D34Renderer extends MobRenderer<D34Entity, ModelD34Model<D34Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d34.png");

	public D34Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD34Model<D34Entity>(context.bakeLayer(ModelD34Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D34Entity entity) {
		if (entity.getTexture() != "d34")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}