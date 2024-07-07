package leetcode.designPatterns.behaviourial.chainOfResponsibility.example2;

public class PaymentProcessingHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("payment"))
            System.out.println("Processing payment for order: " + order);
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
