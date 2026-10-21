package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.SpecialDungeonReloadedMod;

public class BeachscribesOnBlockRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		String ttp = "";
		double nimbawait = 0;
		double testdelay = 0;
		testdelay = 30;
		nimbawait = 0;
		if (getPropertyByName(blockstate, "can_use") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("can_use") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
			ttp = Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_1")).getString();
			if (!(ttp).equals("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_1")) {
				SpecialDungeonReloadedMod.queueServerWork((int) nimbawait, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_1")).getString())),
								false);
				});
				nimbawait = nimbawait + testdelay;
			}
			ttp = Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_2")).getString();
			if (!(ttp).equals("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_2")) {
				SpecialDungeonReloadedMod.queueServerWork((int) nimbawait, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_2")).getString())),
								false);
				});
				nimbawait = nimbawait + testdelay;
			}
			ttp = Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_3")).getString();
			if (!(ttp).equals("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_3")) {
				SpecialDungeonReloadedMod.queueServerWork((int) nimbawait, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_3")).getString())),
								false);
				});
				nimbawait = nimbawait + testdelay;
			}
			ttp = Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_4")).getString();
			if (!(ttp).equals("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_4")) {
				SpecialDungeonReloadedMod.queueServerWork((int) nimbawait, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_4")).getString())),
								false);
				});
				nimbawait = nimbawait + testdelay;
			}
			ttp = Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_5")).getString();
			if (!(ttp).equals("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_5")) {
				SpecialDungeonReloadedMod.queueServerWork((int) nimbawait, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable(("writes.text_" + new java.text.DecimalFormat("#").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "text_id")) + "_5")).getString())),
								false);
				});
				nimbawait = nimbawait + testdelay;
			}
			SpecialDungeonReloadedMod.queueServerWork(50, () -> {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("can_use") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			});
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}