package leetcode.designPatterns.chainOfResponsibility.example1;

public class OrderPreparationHandler extends OrderHandler {

    public OrderPreparationHandler(OrderHandler orderHandler){
        super(orderHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Preparing order: " + order);
        if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
