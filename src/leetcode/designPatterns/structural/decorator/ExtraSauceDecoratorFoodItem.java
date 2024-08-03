package leetcode.designPatterns.structural.decorator;

public class ExtraSauceDecoratorFoodItem extends Decorator{

    private double price;

    public ExtraSauceDecoratorFoodItem(FoodItem foodItem, double price){
        super(foodItem);
        this.price=price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra sauce";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice()+ this.price;
    }
}
