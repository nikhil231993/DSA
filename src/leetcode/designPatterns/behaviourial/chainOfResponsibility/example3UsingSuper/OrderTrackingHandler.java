package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class OrderTrackingHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("tracking"))
            System.out.println("Tracking order: " + order);
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
