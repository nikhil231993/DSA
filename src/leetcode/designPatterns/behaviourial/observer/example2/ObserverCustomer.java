package leetcode.designPatterns.behaviourial.observer.example2;

public class ObserverCustomer implements IObserver{

    @Override
    public void update(Order order) {
        System.out.println("Customer updated about order: " + order.getName());
    }
}
