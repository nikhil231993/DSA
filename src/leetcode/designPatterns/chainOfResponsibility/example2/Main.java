package leetcode.designPatterns.chainOfResponsibility.example2;

public class Main {

    public static void main(String[] args) {

        String order= "amazon";

        OrderValidationHandler orderValidationHandler = new OrderValidationHandler();
        OrderPreparationHandler orderPreparationHandler = new OrderPreparationHandler();
        PaymentProcessingHandler paymentProcessingHandler = new PaymentProcessingHandler();
        DeliveryAssignmentHandler deliveryAssignmentHandler = new DeliveryAssignmentHandler();
        OrderTrackingHandler orderTrackingHandler = new OrderTrackingHandler();

        orderValidationHandler.setHandler(orderPreparationHandler);
        orderPreparationHandler.setHandler(paymentProcessingHandler);
        paymentProcessingHandler.setHandler(deliveryAssignmentHandler);
        deliveryAssignmentHandler.setHandler(orderTrackingHandler);
        //orderTrackingHandler.setHandler(orderValidationHandler); if we add this it will be a recursive call
        //orderTrackingHandler.setHandler(orderTrackingHandler); same here. We should have some break condition

        orderValidationHandler.processOrder(order);
    }
}
