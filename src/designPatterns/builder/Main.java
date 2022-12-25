package designPatterns.builder;

public class Main {

	public static void main(String[] args) {

		ListOfItems mealList = new ListOfItems();
		mealList.addItem(new NonVegMeal());
		mealList.addItem(new VegMeal());
		
		for (Meal m : mealList.items) {
			System.out.println(m.getName());
			System.out.println(m.packing().show());

		}
			

	}

}
