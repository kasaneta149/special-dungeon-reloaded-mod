package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D45Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD45Model;

public class D45Renderer extends MobRenderer<D45Entity, ModelD45Model<D45Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d45.png");

	public D45Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD45Model<D45Entity>(context.bakeLayer(ModelD45Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D45Entity entity) {
		if (entity.getTexture() != "d45")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}