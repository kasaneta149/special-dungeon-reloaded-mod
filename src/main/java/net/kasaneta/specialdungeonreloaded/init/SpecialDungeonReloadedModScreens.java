/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.kasaneta.specialdungeonreloaded.client.gui.VendingmachineguiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class SpecialDungeonReloadedModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SpecialDungeonReloadedModMenus.VENDINGMACHINEGUI.get(), VendingmachineguiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}