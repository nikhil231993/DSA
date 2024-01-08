package leetcode.designPatterns.chainOfResponsibility.example1;

public class OrderTrackingHandler extends OrderHandler {

    public OrderTrackingHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tracking order: " + order);
    }
}
