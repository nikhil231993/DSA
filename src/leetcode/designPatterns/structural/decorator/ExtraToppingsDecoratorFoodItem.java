package leetcode.designPatterns.structural.decorator;

public class ExtraToppingsDecoratorFoodItem extends Decorator{

    private double price;

    public ExtraToppingsDecoratorFoodItem(FoodItem foodItem, double price){ //is a is applicable and used when we pass
        // foodItem in the constructor because if it was not is-a then we cannot pass it in constructor
        super(foodItem);
        this.price=price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra toppings";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice()+ this.price;
    }
}
