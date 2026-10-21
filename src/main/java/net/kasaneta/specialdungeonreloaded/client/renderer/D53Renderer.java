package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D53Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD53Model;

public class D53Renderer extends MobRenderer<D53Entity, ModelD53Model<D53Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d53.png");

	public D53Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD53Model<D53Entity>(context.bakeLayer(ModelD53Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D53Entity entity) {
		if (entity.getTexture() != "d53")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}