/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kasaneta.specialdungeonreloaded.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.kasaneta.specialdungeonreloaded.block.entity.*;
import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

@EventBusSubscriber
public class SpecialDungeonReloadedModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, SpecialDungeonReloadedMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WritesonwallBlockEntity>> WRITESONWALL = register("writesonwall", SpecialDungeonReloadedModBlocks.WRITESONWALL, WritesonwallBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VendingmachineBlockEntity>> VENDINGMACHINE = register("vendingmachine", SpecialDungeonReloadedModBlocks.VENDINGMACHINE, VendingmachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WritesonwallredBlockEntity>> WRITESONWALLRED = register("writesonwallred", SpecialDungeonReloadedModBlocks.WRITESONWALLRED, WritesonwallredBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LasergamecontrollerBlockEntity>> LASERGAMECONTROLLER = register("lasergamecontroller", SpecialDungeonReloadedModBlocks.LASERGAMECONTROLLER,
			LasergamecontrollerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LasergametargetmakerBlockEntity>> LASERGAMETARGETMAKER = register("lasergametargetmaker", SpecialDungeonReloadedModBlocks.LASERGAMETARGETMAKER,
			LasergametargetmakerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BeachscribesBlockEntity>> BEACHSCRIBES = register("beachscribes", SpecialDungeonReloadedModBlocks.BEACHSCRIBES, BeachscribesBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PortaltoliminalityBlockEntity>> PORTALTOLIMINALITY = register("portaltoliminality", SpecialDungeonReloadedModBlocks.PORTALTOLIMINALITY, PortaltoliminalityBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WRITESONWALL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, VENDINGMACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WRITESONWALLRED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LASERGAMECONTROLLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LASERGAMETARGETMAKER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BEACHSCRIBES.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PORTALTOLIMINALITY.get(), SidedInvWrapper::new);
	}
}