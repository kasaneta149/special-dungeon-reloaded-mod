package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D35Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD35Model;

public class D35Renderer extends MobRenderer<D35Entity, ModelD35Model<D35Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d35.png");

	public D35Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD35Model<D35Entity>(context.bakeLayer(ModelD35Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D35Entity entity) {
		if (entity.getTexture() != "d35")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}