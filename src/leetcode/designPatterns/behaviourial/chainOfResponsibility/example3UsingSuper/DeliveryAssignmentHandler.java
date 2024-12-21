package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class DeliveryAssignmentHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("delivery"))
            System.out.println("Assigning delivery for order: " + order);
        else if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
