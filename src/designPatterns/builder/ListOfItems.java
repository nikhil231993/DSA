package designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class ListOfItems {

	public List<Meal> items = new ArrayList<Meal>();

	public void addItem(Meal meal) {
		items.add(meal);
	}

}
