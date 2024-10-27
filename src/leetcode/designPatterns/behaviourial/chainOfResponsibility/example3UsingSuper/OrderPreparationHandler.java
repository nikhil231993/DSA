package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class OrderPreparationHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {
        if(order.equals("preparing"))
            System.out.println("Preparing order: " + order);
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
