package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.Tt5Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD19Model;

public class Tt5Renderer extends MobRenderer<Tt5Entity, ModelD19Model<Tt5Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d19.png");

	public Tt5Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD19Model<Tt5Entity>(context.bakeLayer(ModelD19Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Tt5Entity entity) {
		if (entity.getTexture() != "d19")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}