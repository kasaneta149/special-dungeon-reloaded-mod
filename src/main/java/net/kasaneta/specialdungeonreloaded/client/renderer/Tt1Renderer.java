package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt1Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD45Model;

public class Tt1Renderer extends MobRenderer<Tt1Entity, ModelD45Model<Tt1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d45.png");

	public Tt1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD45Model<Tt1Entity>(context.bakeLayer(ModelD45Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt1Entity entity) {
		if (entity.getTexture() != "d45")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}