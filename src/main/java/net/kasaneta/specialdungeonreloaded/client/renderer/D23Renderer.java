package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D23Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD23Model;

public class D23Renderer extends MobRenderer<D23Entity, ModelD23Model<D23Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d23.png");

	public D23Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD23Model<D23Entity>(context.bakeLayer(ModelD23Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D23Entity entity) {
		if (entity.getTexture() != "d23")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}