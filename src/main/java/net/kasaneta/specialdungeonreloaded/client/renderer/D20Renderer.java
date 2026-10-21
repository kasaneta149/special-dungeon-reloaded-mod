package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.D20Entity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelD20Model;

public class D20Renderer extends MobRenderer<D20Entity, ModelD20Model<D20Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/d20.png");

	public D20Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelD20Model<D20Entity>(context.bakeLayer(ModelD20Model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(D20Entity entity) {
		if (entity.getTexture() != "d20")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}