package net.kasaneta.specialdungeonreloaded.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.kasaneta.specialdungeonreloaded.entity.FinalbossEntity;
import net.kasaneta.specialdungeonreloaded.client.model.ModelFinalbossModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class FinalbossRenderer extends MobRenderer<FinalbossEntity, ModelFinalbossModel<FinalbossEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("special_dungeon_reloaded:textures/entities/finalbossimg18.png");

	public FinalbossRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFinalbossModel<FinalbossEntity>(context.bakeLayer(ModelFinalbossModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(FinalbossEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.5f, 2.5f, 2.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FinalbossEntity entity) {
		if (entity.getTexture() != "finalbossimg18")
			return ResourceLocation.parse("special_dungeon_reloaded:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}