package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public class OrderTrackingHandler extends OrderHandler {

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("tracking1")){
            System.out.println("Tracking order: " + order);
            PaymentProcessingHandler paymentProcessingHandler=new PaymentProcessingHandler();
            setHandler(paymentProcessingHandler);
            orderHandler.processOrder(order);
        }
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
