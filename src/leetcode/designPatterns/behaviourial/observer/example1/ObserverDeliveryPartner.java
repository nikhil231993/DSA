package leetcode.designPatterns.behaviourial.observer.example1;

public class ObserverDeliveryPartner implements Observer {

    private String name;

    public ObserverDeliveryPartner(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(this.name + " status updated for order id: "+ order.getOrderId());
    }
}
