package leetcode.designPatterns.behaviourial.observer.example2;

public class ObserverDeliveryPartner implements IObserver {

    @Override
    public void update(Order order) {
        System.out.println("Delivery Partner updated about order: " + order.getName());
    }
}
