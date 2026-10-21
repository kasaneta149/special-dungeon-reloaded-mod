package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.RegendogEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelRegenDogModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class RegendogRenderer extends MobRenderer<RegendogEntity, ModelRegenDogModel<RegendogEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/regen_dog.png");

	public RegendogRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRegenDogModel<RegendogEntity>(context.bakeLayer(ModelRegenDogModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(RegendogEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.2f, 2.2f, 2.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(RegendogEntity entity) {
		if (entity.getTexture() != "regen_dog")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}