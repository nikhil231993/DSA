package leetcode.designPatterns.decorator;

public class ExtraCheeseDecorator extends Decorator{

    private double price;
    public ExtraCheeseDecorator(FoodItem foodItem, double price) {
        super(foodItem);
        this.price=price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription()+ " with extra cheese";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice()+ this.price;
    }
}
