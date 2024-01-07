package leetcode.designPatterns.decorator;

public class Burger implements  FoodItem{
    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 200.0;
    }
}
