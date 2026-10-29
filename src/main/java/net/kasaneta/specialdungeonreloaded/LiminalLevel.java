package net.kasaneta.specialdungeonreloaded.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class LiminalLevel {
	public static final String NAMESPACE = "special_dungeon_reloaded";
	public static final int CELL_SIZE = 48;

	public interface CellCondition {
		boolean test(int gridX, int gridZ);
	}

	public interface TickEffect {
		void apply(ServerLevel level, LivingEntity entity);
	}

	public record Choice(ResourceLocation structure, double weight) {
	}

	private record Rule(CellCondition where, Choice[] choices, double totalWeight) {
		private ResourceLocation pick(RandomSource random) {
			if (choices.length == 0)
				return null;
			if (choices.length == 1)
				return choices[0].structure();
			double roll = random.nextDouble() * totalWeight;
			for (Choice choice : choices) {
				roll -= choice.weight();
				if (roll < 0)
					return choice.structure();
			}
			return choices[choices.length - 1].structure();
		}
	}

	private record Exit(Predicate<Entity> condition, ResourceKey<Level> destination) {
	}

	private enum Corridor {
		NONE, ALONG_X, ALONG_Z
	}

	private final ResourceLocation id;
	private final List<Exit> exits = new ArrayList<>();
	private final List<Rule> rules = new ArrayList<>();
	private int minX = Integer.MIN_VALUE;
	private int maxX = Integer.MAX_VALUE;
	private int minZ = Integer.MIN_VALUE;
	private int maxZ = Integer.MAX_VALUE;
	private Corridor corridor = Corridor.NONE;
	private int corridorHalfWidth = 0;
	private int structureY = 150;
	private int markerY = 20;
	private int preloadRadius = 3;
	private TickEffect tickEffect = null;

	private LiminalLevel(ResourceLocation id) {
		this.id = id;
	}

	public static LiminalLevel named(String dimension) {
		return new LiminalLevel(ResourceLocation.fromNamespaceAndPath(NAMESPACE, dimension));
	}

	public static Choice choice(String structure, double weight) {
		return new Choice(ResourceLocation.fromNamespaceAndPath(NAMESPACE, structure), weight);
	}

	public LiminalLevel minX(int value) {
		minX = value;
		return this;
	}

	public LiminalLevel maxX(int value) {
		maxX = value;
		return this;
	}

	public LiminalLevel minZ(int value) {
		minZ = value;
		return this;
	}

	public LiminalLevel maxZ(int value) {
		maxZ = value;
		return this;
	}

	public LiminalLevel alongX() {
		return alongX(0);
	}

	public LiminalLevel alongX(int halfWidthInCells) {
		corridor = Corridor.ALONG_X;
		corridorHalfWidth = halfWidthInCells;
		return this;
	}

	public LiminalLevel alongZ() {
		return alongZ(0);
	}

	public LiminalLevel alongZ(int halfWidthInCells) {
		corridor = Corridor.ALONG_Z;
		corridorHalfWidth = halfWidthInCells;
		return this;
	}

	public LiminalLevel structureY(int value) {
		structureY = value;
		return this;
	}

	public LiminalLevel markerY(int value) {
		markerY = value;
		return this;
	}

	public LiminalLevel preloadRadius(int value) {
		preloadRadius = value;
		return this;
	}

	public LiminalLevel perTick(TickEffect effect) {
		tickEffect = effect;
		return this;
	}

	public LiminalLevel exitTo(String dimension, Predicate<Entity> condition) {
		exits.add(new Exit(condition, ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(NAMESPACE, dimension))));
		return this;
	}

	public LiminalLevel exitToOverworld(Predicate<Entity> condition) {
		exits.add(new Exit(condition, Level.OVERWORLD));
		return this;
	}

	public LiminalLevel rule(CellCondition where, String structure) {
		return rule(where, choice(structure, 1));
	}

	public LiminalLevel rule(CellCondition where, Choice... choices) {
		double total = 0;
		for (Choice choice : choices)
			total += choice.weight();
		rules.add(new Rule(where, choices, total));
		return this;
	}

	public LiminalLevel skip(CellCondition where) {
		return rule(where);
	}

	public ResourceLocation id() {
		return id;
	}

	public int structureY() {
		return structureY;
	}

	public int markerY() {
		return markerY;
	}

	public int preloadRadius() {
		return preloadRadius;
	}

	public boolean allows(int cellX, int cellZ) {
		if (corridor == Corridor.ALONG_X && Math.abs(cellZ) > corridorHalfWidth)
			return false;
		if (corridor == Corridor.ALONG_Z && Math.abs(cellX) > corridorHalfWidth)
			return false;
		int gridX = cellX * CELL_SIZE;
		int gridZ = cellZ * CELL_SIZE;
		return gridX < maxX && gridX + CELL_SIZE > minX && gridZ < maxZ && gridZ + CELL_SIZE > minZ;
	}

	public ResourceLocation pickStructure(int gridX, int gridZ, RandomSource random) {
		for (int i = 0; i < rules.size(); i++) {
			Rule rule = rules.get(i);
			if (rule.where().test(gridX, gridZ))
				return rule.pick(random);
		}
		return null;
	}

	public ResourceKey<Level> exitFor(Entity entity) {
		for (int i = 0; i < exits.size(); i++) {
			Exit exit = exits.get(i);
			if (exit.condition().test(entity))
				return exit.destination();
		}
		return null;
	}

	public void applyEffect(ServerLevel level, Entity entity) {
		if (tickEffect != null && entity instanceof LivingEntity living)
			tickEffect.apply(level, living);
	}
}