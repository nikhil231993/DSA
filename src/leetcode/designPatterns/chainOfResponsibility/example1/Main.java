package leetcode.designPatterns.chainOfResponsibility.example1;

public class Main {

    public static void main(String[] args) {

        String order= "amazon";

        OrderHandler orderHandler=new OrderValidationHandler
                (new OrderPreparationHandler
                        (new PaymentProcessingHandler
                        (new DeliveryAssignmentHandler
                                (new OrderTrackingHandler(null)))));

        orderHandler.processOrder(order);
    }
}
