package leetcode.designPatterns.structural.decorator;

public class Main {

    public static void main(String[] args) {

        FoodItem pizza=new Pizza();
        pizza = new ExtraSauceDecoratorFoodItem(new ExtraCheeseDecoratorFoodItem(pizza,10.0), 20);
//        pizza = new ExtraSauceDecoratorFoodItem(pizza, 20.0);
//        pizza = new ExtraToppingsDecoratorFoodItem(pizza, 30.0);

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

        FoodItem burger=new Burger();
        burger=new ExtraCheeseDecoratorFoodItem(burger,10.0);
        burger=new ExtraSauceDecoratorFoodItem(burger, 20.0);
        burger=new ExtraToppingsDecoratorFoodItem(burger, 30.0);

        System.out.println(burger.getDescription());
        System.out.println(burger.getPrice());
    }
}
