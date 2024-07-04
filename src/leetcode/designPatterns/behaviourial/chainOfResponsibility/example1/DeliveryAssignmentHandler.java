package leetcode.designPatterns.behaviourial.chainOfResponsibility.example1;

public class DeliveryAssignmentHandler extends OrderHandler {

    public DeliveryAssignmentHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {

        System.out.println("Assigning delivery for order: " + order);
        if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
