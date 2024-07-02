package leetcode.designPatterns.chainOfResponsibility.example2;

public class PaymentProcessingHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {

        System.out.println("Processing payment for order: " + order);
        if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
