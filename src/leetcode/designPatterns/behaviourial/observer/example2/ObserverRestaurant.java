package leetcode.designPatterns.behaviourial.observer.example2;

public class ObserverRestaurant implements IObserver{

    @Override
    public void update(Order order) {
        System.out.println("Restaurant updated about order: " + order.getName());
    }
}
