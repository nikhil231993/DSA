package leetcode.designPatterns.structural.decorator;

public class ExtraCheeseDecoratorFoodItem extends Decorator{

    private double price;

    public ExtraCheeseDecoratorFoodItem(FoodItem foodItem, double price) {
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
