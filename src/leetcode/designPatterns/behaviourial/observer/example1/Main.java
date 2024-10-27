package leetcode.designPatterns.behaviourial.observer.example1;

public class Main {

    public static void main(String[] args) {

        Observer customerObserver=new ObserverCustomer("Nikhil");
        Observer restaurant=new ObserverRestaurant("Dominos");
        Observer deliveryPartner=new ObserverDeliveryPartner("Swiggy");

        OrderStatusTracker orderStatusTracker=new OrderStatusTracker();
        orderStatusTracker.registerObservers(customerObserver);
        orderStatusTracker.registerObservers(restaurant);
        orderStatusTracker.registerObservers(deliveryPartner);

        Order order1=new Order("Pizza", 1, "Placed");
        orderStatusTracker.addOrder(order1);

        System.out.println("==============================================================");

        Order order2=new Order("Biryani", 2, "Placed");
        orderStatusTracker.addOrder(order2);

        System.out.println("==============================================================");

        Order order3=new Order("Buger", 3, "Placed");
        orderStatusTracker.unregisterObservers(deliveryPartner);
        orderStatusTracker.addOrder(order3);
    }
}
