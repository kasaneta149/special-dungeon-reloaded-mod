package net.kasaneta.specialdungeonreloaded.procedures;

import com.mojang.blaze3d.vertex.PoseStack;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.util.RandomSource;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Minecraft;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModMobEffects;

@EventBusSubscriber(value = Dist.CLIENT)
public class ScreamerHudShakeProcedure {
	private static final float INTENSITY = 2.0f;
	private static final RandomSource RANDOM = RandomSource.create();
	private static boolean shaking = false;

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onGuiPre(RenderGuiEvent.Pre event) {
		shaking = false;
		if (event.isCanceled())
			return;
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null || !player.hasEffect(SpecialDungeonReloadedModMobEffects.NOTCARREFUL))
			return;
		shaking = true;
		PoseStack pose = event.getGuiGraphics().pose();
		pose.pushPose();
		pose.translate((RANDOM.nextFloat() - 0.5f) * 2 * INTENSITY, (RANDOM.nextFloat() - 0.5f) * 2 * INTENSITY, 0);
	}

	@SubscribeEvent
	public static void onGuiPost(RenderGuiEvent.Post event) {
		if (!shaking)
			return;
		shaking = false;
		event.getGuiGraphics().pose().popPose();
	}
}
