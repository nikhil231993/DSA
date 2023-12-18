package leetcode.designPatterns.observer;

public class DeliveryPartnerObserver implements Observer{

    private String name;

    public DeliveryPartnerObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(this.name + "status updated for order id: "+ order.getOrderId());
    }
}
