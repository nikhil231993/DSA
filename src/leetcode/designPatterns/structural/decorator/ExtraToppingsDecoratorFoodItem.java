package leetcode.designPatterns.structural.decorator;

public class ExtraToppingsDecoratorFoodItem extends Decorator{

    private double price;

    public ExtraToppingsDecoratorFoodItem(FoodItem foodItem, double price){
        super(foodItem);
        this.price=price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " extra toppings";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice()+ this.price;
    }
}
