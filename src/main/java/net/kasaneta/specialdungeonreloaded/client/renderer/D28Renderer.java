package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D28Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD28Model;

public class D28Renderer extends MobRenderer<D28Entity, ModelD28Model<D28Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d28.png");

	public D28Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD28Model<D28Entity>(context.bakeLayer(ModelD28Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D28Entity entity) {
		if (entity.getTexture() != "d28")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}