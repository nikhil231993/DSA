package leetcode.designPatterns.observer;

public class Main {

    public static void main(String[] args) {

        Order order1=new Order("Pizza", 1, "Placed");
        OrderTracker orderTracker=new OrderTracker();
        orderTracker.addOrder(order1);

        Observer customerObserver=new CustomerObserver("Nikhil");
        Observer restaurant=new RestaurantObserver("Dominos");
        Observer deliveryPartner=new DeliveryPartnerObserver("Swiggy");

        Order order2=new Order("Biryani", 2, "Placed");
        orderTracker.register(customerObserver);
        orderTracker.register(restaurant);
        orderTracker.register(deliveryPartner);

        orderTracker.addOrder(order2);

        Order order3=new Order("Buger", 3, "Placed");
        orderTracker.unregister(deliveryPartner);
        orderTracker.addOrder(order3);
    }
}
