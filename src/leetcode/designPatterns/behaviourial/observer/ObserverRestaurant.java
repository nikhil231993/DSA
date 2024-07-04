package leetcode.designPatterns.behaviourial.observer;

public class ObserverRestaurant implements Observer{

    private String name;

    public ObserverRestaurant(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(this.name + "status updated for order id: "+ order.getOrderId());
    }
}
