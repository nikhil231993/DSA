package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class OrderValidationHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("validation"))
            System.out.println("Validating order: " + order);
        else if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
