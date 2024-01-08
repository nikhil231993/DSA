package leetcode.designPatterns.decorator;

public class ExtraSauceDecorator extends Decorator{

    private double price;
    public ExtraSauceDecorator(FoodItem foodItem, double price){
        super(foodItem);
        this.price=price;
    }
    @Override
    public String getDescription() {
        return foodItem.getDescription() + " extra sauce";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice()+ this.price;
    }
}
