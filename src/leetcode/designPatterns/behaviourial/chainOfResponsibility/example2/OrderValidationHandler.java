package leetcode.designPatterns.behaviourial.chainOfResponsibility.example2;

public class OrderValidationHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {

        if(order.equalsIgnoreCase("validation"))
            System.out.println("Validating order: " + order);
        else if(orderHandler!=null){
            orderHandler.processOrder(order);
        }
    }
}
