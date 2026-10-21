package net.kasaneta.specialdungeonreloaded.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GivestartachiProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(ResourceLocation.parse("special_dungeon_reloaded:acallred"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("special_dungeon_reloaded:acallred"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon item ~ ~ ~ {Item:{id:written_book,components:{written_book_content:{pages:['[[\"Bienvenue dans le mod Special Dungeon Reloaded : ce mod propose plus de \",{\"text\":\"170 \",\"color\":\"aqua\"},\"niveaux uniques \u00E0 explorer.\"]]','[[\"Pour commencer, vous devrez trouver un moyen d\\'acc\u00E9der au donjon color\u00E9. Dans ces donjons, vous trouverez 4 portails menant \u00E0 diff\u00E9rents types de donjons.\"]]','[[\"Tous ces types de donjons ont leurs propres caract\u00E9ristiques ; votre objectif est d\\'atteindre le seigneur des chiens supr\u00EAme et de le tuer, mais cela s\\'av\u00E9rera extr\u00EAmement difficile.\\\\nVoici un petit r\u00E9sum\u00E9 de tous les donjons :\"]]','[[\"CORRUPTION : bonus et ressources gratuites\\\\n\",{\"text\":\"L\\'IMMEUBLE\",\"color\":\"red\"},\" : atteignez le dernier \u00E9tage et r\u00E9cup\u00E9rer des objet extr\u00EAmement puissants\\\\n\",{\"text\":\"L\\'USINE \",\"color\":\"gray\"},\": indispensable pour fabriquer une cl\u00E9\\\\n\",{\"text\":\"ESPACES LIMINAUX\",\"color\":\"dark_green\"},\" : exploration et importantes r\u00E9compenses en ressources\"]]','[[\"COMMENT Y ACCEDER ?\\\\nRendez-vous dans la \",{\"text\":\"dimension des r\u00EAves\",\"color\":\"aqua\"},\" ; vous devrez \u00E9quiper une casquette en cuir avec l\\'enchantement \",{\"text\":\"r\u00EAveur\",\"color\":\"blue\"},\".\\\\n\",{\"text\":\"REMARQUE : vous pouvez facilement l\\'obtenir \u00E0 l\\'aide d\\'une table d\\'enchantement.\",\"bold\":true}]]','[[\"Ensuite, tu devras dormir dans un lit, tu te r\u00E9veilleras dans un endroit inconnu..., tu l\\'exploreras un peu et tu trouveras le portail menant au donjon ; ce ne sera pas facile, une simple armure de fer ne suffira pas...\\\\n\"]]'],generation:0,resolved:1,title:\"\",author:\"\"},custom_name:'[{\"text\":\"[FRANCAIS] Special dungeon reloaded\",\"italic\":false}]',lore:['[{\"text\":\"Ce livre vous indiquera toutes les \u00E9tapes \u00E0 suivre pour vous lancer dans le mod.\",\"italic\":false}]']}}}");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon item ~ ~ ~ {Item:{id:written_book,components:{written_book_content:{pages:['[[\"Welcome to the mod \\\\nspecial dungeon reloaded, this mod feature over \",{\"text\":\"170 \",\"color\":\"aqua\"},\"unique build to explore.\"]]','[[\"To begin, you will have to find a way to get in the colored dungeon, in these dungeon you will be able to find 4 portal to different dungeon type.\"]]','[[\"All of these dungeon type have ther specifit trait, your goal is to reach the ultimate dog lord and kill it, but it will be extremely hard.\\\\nhere is a little summary of all the dungeon:\"]]','[[\"CORRUPTION: bonus and free ressources \\\\n\",{\"text\":\"THE BUILDING\",\"color\":\"red\"},\": Reach the highest floor and pass the shield to grab really powerful tools and armors\\\\n\",{\"text\":\"THE FACTORY\",\"color\":\"gray\"},\": required in order to craft a key\\\\n\",{\"text\":\"LIMINAL SPACES\",\"color\":\"dark_green\"},\": exploration and big ressource rewards\"]]','[[\"how to get in ?\\\\nhead to the \",{\"text\":\"dream \",\"color\":\"aqua\"},\"dimention, you will need to equip a leather with \",{\"text\":\"dreamer \",\"color\":\"blue\"},\"on a leather cap.\\\\nNOTE: you \",{\"text\":\"can easily obtain\",\"bold\":true},\" it in a enchant table.\"]]','[[\"then you will need to sleep in a bed, you will wake up in a strange place...., explore it a bit, and find the portal to the dungeon, it wont be easy, a simple iron armor won\\'t fit...\\\\n\"]]'],generation:0,resolved:1,title:\"\",author:\"\"},custom_name:'[{\"text\":\"[ENGLISH] Special dungeon reloaded\",\"italic\":false}]',lore:['[{\"text\":\"This book will indicate all the steps to begin your adventure in the dungeon\",\"italic\":false}]']}}}");
		}
	}
}