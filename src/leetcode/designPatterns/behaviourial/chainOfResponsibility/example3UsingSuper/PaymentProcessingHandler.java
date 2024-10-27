package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class PaymentProcessingHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("payment"))
            System.out.println("Processing payment for order: " + order);
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
