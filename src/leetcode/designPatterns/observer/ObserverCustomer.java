package leetcode.designPatterns.observer;

public class ObserverCustomer implements Observer{

    private String name;

    public ObserverCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(this.name + "status updated for order id: "+ order.getOrderId());
    }
}
