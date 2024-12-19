package leetcode.designPatterns.behaviourial.observer.example2;

public class Main {

    public static void main(String[] args) {

        //Below is an example of composition where Observable is inside the subject
        //https://refactoring.guru/design-patterns/observer

        Order order1=new Order("1", "Food");

        ObserverCustomer customer1=new ObserverCustomer();
        ObserverDeliveryPartner delivery1=new ObserverDeliveryPartner();
        ObserverRestaurant restaurant1=new ObserverRestaurant();

        order1.tracker.register(customer1);
        order1.tracker.register(delivery1);
        order1.tracker.register(restaurant1);
        order1.updateStatus(order1);

        System.out.println("########## Amazon Orders ##############"); // This will have separate list as there is not restaurant partner

        Order order2=new Order("2", "Clothes");
        ObserverCustomer customer2=new ObserverCustomer();
        ObserverDeliveryPartner delivery2=new ObserverDeliveryPartner();

        order2.tracker.register(customer2);
        order2.tracker.register(delivery2);
        order2.updateStatus(order2);
    }
}
