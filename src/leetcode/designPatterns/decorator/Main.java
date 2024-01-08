package leetcode.designPatterns.decorator;

public class Main {

    public static void main(String[] args) {

        FoodItem pizza=new Pizza();
        pizza=new ExtraCheeseDecorator(pizza,10.0);
        pizza=new ExtraSauceDecorator(pizza, 20.0);
        pizza=new ExtraToppingsDecorator(pizza, 30.0);

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());

        FoodItem burger=new Burger();
        burger=new ExtraCheeseDecorator(burger,10.0);
        burger=new ExtraSauceDecorator(burger, 20.0);
        burger=new ExtraToppingsDecorator(burger, 30.0);

        System.out.println(burger.getDescription());
        System.out.println(burger.getPrice());
    }
}
