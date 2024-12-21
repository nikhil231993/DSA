package leetcode.designPatterns.behaviourial.chainOfResponsibility.example2;

public class OrderPreparationHandler extends OrderHandler {

    private OrderHandler orderHandler;

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    @Override
    public void processOrder(String order) {

        if(order.equals("preparing"))
            System.out.println("Preparing order: " + order);
        else if(orderHandler!=null)
            orderHandler.processOrder(order);
    }
}
