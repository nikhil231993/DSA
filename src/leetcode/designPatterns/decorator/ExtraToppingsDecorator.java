package leetcode.designPatterns.decorator;

public class ExtraToppingsDecorator extends Decorator{

    private double price;

    public ExtraToppingsDecorator(FoodItem foodItem, double price){
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
