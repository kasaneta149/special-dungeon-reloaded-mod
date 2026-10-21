package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D40Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD40Model;

public class D40Renderer extends MobRenderer<D40Entity, ModelD40Model<D40Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d40.png");

	public D40Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD40Model<D40Entity>(context.bakeLayer(ModelD40Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D40Entity entity) {
		if (entity.getTexture() != "d40")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}