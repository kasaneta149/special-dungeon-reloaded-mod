package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

public class LiminalLevels {
	private static final LiminalLevel.CellCondition ANYWHERE = (x, z) -> true;
	private static final LiminalLevel.CellCondition CENTER = (x, z) -> x == 0 && z == 0;

	private static final Map<ResourceLocation, LiminalLevel> LEVELS = new HashMap<>();

	static {
		add(level("lsbeachdim")
				.maxX(500)
				.exitToOverworld(player -> player.getY() >= 200)
				.exitTo("lscampement", player -> player.getX() >= 500)
				.rule((x, z) -> x > 0, "ls_beach_sand")
				.rule((x, z) -> x < 0, "ls_beach_ocean")
				.rule(ANYWHERE,
						choice("ls_beach_main", 100),
						choice("ls_beach_main_sec2", 100),
						choice("ls_beach_main_sec3", 100),
						choice("ls_beach_main_sec4", 100),
						choice("ls_beach_main_sec5", 100),
						choice("ls_beach_main_sec6", 93),
						choice("ls_beach_main_sec6_withdog", 7)));

		add(level("lscampement")
				.rule(CENTER, "ls_campement_main")
				.rule(ANYWHERE,
						choice("ls_campement_forest1", 83),
						choice("ls_campement_forest2", 17)));

		add(level("lsvilleinfinie")
				.minX(-350)
				.maxX(350)
				.exitTo("lslacavedim", player -> Math.abs(player.getX()) >= 350)
				.rule(ANYWHERE,
						choice("ls_ville_infinie_1", 94),
						choice("ls_ville_infinie_1_bus", 6)));

		add(level("lslacavedim")
				.rule(ANYWHERE,
						choice("ls_la_cave_1", 745),
						choice("ls_la_cave_2", 45),
						choice("ls_la_cave_3", 90),
						choice("ls_la_cave_4", 30),
						choice("ls_la_cave_5", 30),
						choice("ls_la_cave_6", 15),
						choice("ls_la_cave_7", 15),
						choice("ls_la_cave_8", 30)));

		add(level("lspiscinedim")
				.rule(ANYWHERE,
						choice("lslapiscine_1", 1),
						choice("lslapiscine_2", 1),
						choice("lslapiscine_3", 1)));

		add(level("lsmaisoninonde")
				.rule(CENTER, "lsmaisoninonde")
				.rule(ANYWHERE,
						choice("lsmaisoninonde_ocean", 58.75),
						choice("lsmaisoninonde_ocean_stal1", 13.75),
						choice("lsmaisoninonde_ocean_stal2", 13.75),
						choice("lsmaisoninonde_ocean_stal3", 6.1875),
						choice("lsmaisoninonde_ocean_stal4_bus", 2.75),
						choice("lsmaisoninonde_ocean_stal5_market", 4.8125)));

		add(level("lscentrecommercialdim")
				.alongZ()
				.rule(ANYWHERE,
						choice("lscentrecommercial", 1),
						choice("lscentrecommercial_alt", 1),
						choice("lscentrecommercial_middle", 0.95),
						choice("lscentrecommercial_middle_portal", 0.05)));

		add(level("lsstationessencedim")
				.rule((x, z) -> x != 0,
						choice("lsstationessence_forest", 80),
						choice("lsstationessence_monster_forest", 20))
				.rule(CENTER, "lsstationessence")
				.rule((x, z) -> z >= 400,
						choice("lsstationessence_road", 83),
						choice("lsstationessence_road_monster_forest_bus", 10),
						choice("lsstationessence_road_monster_forest", 7.0 / 3),
						choice("lsstationessence_road_monster_forest2", 7.0 / 3),
						choice("lsstationessence_road_monster_forest3", 7.0 / 3))
				.rule(ANYWHERE,
						choice("lsstationessence_road", 83),
						choice("lsstationessence_road_monster_forest", 7.0 / 3),
						choice("lsstationessence_road_monster_forest2", 7.0 / 3),
						choice("lsstationessence_road_monster_forest3", 10 + 7.0 / 3)));

		add(level("lschamprougedim")
				.rule(ANYWHERE,
						choice("lschamprouge", 85),
						choice("lschamprouge_hole", 15)));

		add(level("lschampinfini")
				.rule(ANYWHERE,
						choice("lschampinfini", 75),
						choice("lschampinfini_pilleur", 13),
						choice("lschampinfini_bureau_entrace", 12)));

		add(level("lsbureaudim")
				.rule(CENTER, "lslesbureau")
				.rule(ANYWHERE,
						choice("lslesbureau", 88),
						choice("lslesbureau_2", 12)));

		add(level("lsbureauabandonedim")
				.alongZ()
				.rule(ANYWHERE, "lslesbureauabandonnes"));

		add(level("lsetatdefoliedim")
				.perTick(LiminalEffects::madness)
				.rule(CENTER, "lsetatdefolie")
				.rule(ANYWHERE,
						choice("lsetatdefolie", 79),
						choice("lsetatdefolie_glass", 8),
						choice("lsetatdefolie_bus", 13)));
	}

	public static LiminalLevel get(ResourceLocation dimension) {
		return LEVELS.get(dimension);
	}

	private static void add(LiminalLevel level) {
		LEVELS.put(level.id(), level);
	}

	private static LiminalLevel level(String dimension) {
		return LiminalLevel.named(dimension);
	}

	private static LiminalLevel.Choice choice(String structure, double weight) {
		return LiminalLevel.choice(structure, weight);
	}
}