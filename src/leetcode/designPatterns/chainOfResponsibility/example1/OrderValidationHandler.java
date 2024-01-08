package leetcode.designPatterns.chainOfResponsibility.example1;

public class OrderValidationHandler extends OrderHandler {

    public OrderValidationHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Validating order: " + order);
        if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
