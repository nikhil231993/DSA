package leetcode.designPatterns.chainOfResponsibility.example1;

public class PaymentProcessingHandler extends OrderHandler {

    public PaymentProcessingHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Processing payment for order: " + order);
        if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
