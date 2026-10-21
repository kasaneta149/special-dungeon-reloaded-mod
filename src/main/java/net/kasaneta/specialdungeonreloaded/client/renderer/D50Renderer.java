package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D50Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD50Model;

public class D50Renderer extends MobRenderer<D50Entity, ModelD50Model<D50Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d50.png");

	public D50Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD50Model<D50Entity>(context.bakeLayer(ModelD50Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D50Entity entity) {
		if (entity.getTexture() != "d50")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}