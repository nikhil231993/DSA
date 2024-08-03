package leetcode.designPatterns.behaviourial.chainOfResponsibility.example1;

public class OrderTrackingHandler extends OrderHandler {

    public OrderTrackingHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {

        System.out.println("Tracking order: " + order);
        if(this.orderHandler!=null)
            System.out.println("Processed");
        System.out.println("Not processed");
    }
}
