package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D55Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD55Model;

public class D55Renderer extends MobRenderer<D55Entity, ModelD55Model<D55Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d55.png");

	public D55Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD55Model<D55Entity>(context.bakeLayer(ModelD55Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D55Entity entity) {
		if (entity.getTexture() != "d55")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}