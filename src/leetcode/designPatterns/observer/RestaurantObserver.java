package leetcode.designPatterns.observer;

public class RestaurantObserver implements Observer{

    private String name;

    public RestaurantObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(this.name + "status updated for order id: "+ order.getOrderId());
    }
}
