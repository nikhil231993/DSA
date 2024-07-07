package leetcode.designPatterns.behaviourial.chainOfResponsibility.example2;

public class DeliveryAssignmentHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {
        if(order.equalsIgnoreCase("delivery"))
            System.out.println("Assigning delivery for order: " + order);
        else if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
