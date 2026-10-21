package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.kasaneta.specialdungeonreloaded.init.SpecialDungeonReloadedModBlocks;

public class OpenPurpleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, ItemStack itemstack) {
		if (blockstate.getBlock() == SpecialDungeonReloadedModBlocks.PURPLEDOOR.get()) {
			itemstack.setCount(0);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/title @p actionbar [\"\",{\"text\":\"Purple door:\",\"color\":\"dark_blue\"},\" \",{\"text\":\"Unlocked!\",\"color\":\"purple\"}]");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:open_door")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:open_door")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}