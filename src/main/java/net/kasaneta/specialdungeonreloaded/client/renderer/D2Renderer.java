package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D2Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD2Model;

public class D2Renderer extends MobRenderer<D2Entity, ModelD2Model<D2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d2.png");

	public D2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD2Model<D2Entity>(context.bakeLayer(ModelD2Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D2Entity entity) {
		if (entity.getTexture() != "d2")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}