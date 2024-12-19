package leetcode.designPatterns.behaviourial.observer.example1;

public class Main {

    public static void main(String[] args) {

        Observer customerObserver=new ObserverCustomer("Nikhil");
        Observer restaurant=new ObserverRestaurant("Dominos");
        Observer deliveryPartner=new ObserverDeliveryPartner("Swiggy");

        OrderStatusTracker orderStatusTracker1=new OrderStatusTracker();
        orderStatusTracker1.registerObservers(customerObserver);
        orderStatusTracker1.registerObservers(restaurant);
        orderStatusTracker1.registerObservers(deliveryPartner);

        OrderStatusTracker orderStatusTracker2=new OrderStatusTracker();
        orderStatusTracker2.registerObservers(customerObserver);
        orderStatusTracker2.registerObservers(restaurant);

        Order order1=new Order("Pizza", 1, "Placed");
        orderStatusTracker1.addOrder(order1);

        System.out.println("==============================================================");

        Order order2=new Order("Clothes", 2, "Placed");
        orderStatusTracker2.addOrder(order2);

        System.out.println("==============================================================");

        Order order3=new Order("Shoes", 3, "Placed");
        //orderStatusTracker1.unregisterObservers(deliveryPartner);
        orderStatusTracker2.addOrder(order3);
    }
}
