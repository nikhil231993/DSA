package designPatterns.builder;

public class NonVegMeal implements Meal {

	@Override
	public String getName() {
		return "Non Veg Pizza";

	}

	public Packing packing() {
		return new Packing();
	}

}
