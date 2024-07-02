package leetcode.designPatterns.observer;

public class Main {

    public static void main(String[] args) {

        Observer customerObserver=new ObserverCustomer("Nikhil");
        Observer restaurant=new ObserverRestaurant("Dominos");
        Observer deliveryPartner=new ObserverDeliveryPartner("Swiggy");

        OrderTracker orderTracker=new OrderTracker();
        orderTracker.registerObservers(customerObserver);
        orderTracker.registerObservers(restaurant);
        orderTracker.registerObservers(deliveryPartner);

        Order order1=new Order("Pizza", 1, "Placed");
        orderTracker.addOrder(order1);

        System.out.println("==============================================================");

        Order order2=new Order("Biryani", 2, "Placed");
        orderTracker.addOrder(order2);

        System.out.println("==============================================================");

        Order order3=new Order("Buger", 3, "Placed");
        orderTracker.unregisterObservers(deliveryPartner);
        orderTracker.addOrder(order3);
    }
}
