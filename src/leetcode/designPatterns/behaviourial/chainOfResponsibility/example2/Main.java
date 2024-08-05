package leetcode.designPatterns.behaviourial.chainOfResponsibility.example2;

public class Main {

    public static void main(String[] args) {

        //1. We can even ste handler next handler within the handler at runtime
        //2. we can have multiple successor
        //3. we can pass two handler in parameter so that based on success or failure we can decide which handler to use
        // OrderPreparationHandler orderPreparationHandler = new OrderPreparationHandler(successHandler, failureHandler);

        String order= "delivery";

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
        orderValidationHandler.processOrder("preparing");
        orderValidationHandler.processOrder("tracking");
        orderValidationHandler.processOrder("payment");
        orderValidationHandler.processOrder("validation");
    }
}
