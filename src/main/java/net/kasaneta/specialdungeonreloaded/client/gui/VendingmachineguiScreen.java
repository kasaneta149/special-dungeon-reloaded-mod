package net.kasaneta.specialdungeonreloaded.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.kasaneta.specialdungeonreloaded.world.inventory.VendingmachineguiMenu;
import net.kasaneta.specialdungeonreloaded.procedures.GetMoneyStringProcedure;
import net.kasaneta.specialdungeonreloaded.network.VendingmachineguiButtonMessage;
import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class VendingmachineguiScreen extends AbstractContainerScreen<VendingmachineguiMenu> implements SpecialDungeonReloadedModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_acheter;
	private Button button_acheter1;
	private Button button_acheter2;
	private Button button_acheter3;
	private Button button_acheter4;
	private Button button_acheter5;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("special_dungeon_reloaded:textures/screens/vendingmachinegui.png");

	public VendingmachineguiScreen(VendingmachineguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 185;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_vending_machine"), 84, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_paquet_de_bonbon"), 75, 42, -12829636, false);
		guiGraphics.drawString(this.font, GetMoneyStringProcedure.execute(entity), 12, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_boisson_350eu"), 75, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_horaire_de_bus_5eu"), 75, 86, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_cle_aleatoire_25eu"), 75, 108, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_nourriture_150eu"), 75, 130, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.label_potion_2eu"), 75, 152, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_acheter = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(0, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 38, 60, 20).build();
		this.addRenderableWidget(button_acheter);
		button_acheter1 = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter1"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(1, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 60, 60, 20).build();
		this.addRenderableWidget(button_acheter1);
		button_acheter2 = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter2"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(2, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 82, 60, 20).build();
		this.addRenderableWidget(button_acheter2);
		button_acheter3 = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter3"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(3, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 104, 60, 20).build();
		this.addRenderableWidget(button_acheter3);
		button_acheter4 = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter4"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(4, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 126, 60, 20).build();
		this.addRenderableWidget(button_acheter4);
		button_acheter5 = Button.builder(Component.translatable("gui.special_dungeon_reloaded.vendingmachinegui.button_acheter5"), e -> {
			int x = VendingmachineguiScreen.this.x;
			int y = VendingmachineguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new VendingmachineguiButtonMessage(5, x, y, z));
				VendingmachineguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 148, 60, 20).build();
		this.addRenderableWidget(button_acheter5);
	}
}