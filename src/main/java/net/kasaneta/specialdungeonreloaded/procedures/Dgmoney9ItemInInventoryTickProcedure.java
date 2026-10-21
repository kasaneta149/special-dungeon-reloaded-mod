package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.kasaneta.specialdungeonreloaded.network.SpecialDungeonReloadedModVariables;

public class Dgmoney9ItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double added_moula = 0;
		added_moula = 0.2 * itemstack.getCount();
		{
			SpecialDungeonReloadedModVariables.PlayerVariables _vars = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES);
			_vars.dungeon_money = entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money + added_moula;
			_vars.markSyncDirty();
		}
		itemstack.setCount(0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:coins_pickup")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("special_dungeon_reloaded:coins_pickup")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal((Component.translatable("ui.newmoula").getString() + "" + new java.text.DecimalFormat("##.## \u20AC").format(entity.getData(SpecialDungeonReloadedModVariables.PLAYER_VARIABLES).dungeon_money))), true);
	}
}