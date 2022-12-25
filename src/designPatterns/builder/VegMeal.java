package designPatterns.builder;

public class VegMeal implements Meal {

	@Override
	public String getName() {
		return "Veg Pizza";

	}

	public Packing packing() {
		return new Packing();
	}

}
