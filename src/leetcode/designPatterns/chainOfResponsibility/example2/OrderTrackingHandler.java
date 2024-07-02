package leetcode.designPatterns.chainOfResponsibility.example2;

public class OrderTrackingHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {

        System.out.println("Tracking order: " + order);
        if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
