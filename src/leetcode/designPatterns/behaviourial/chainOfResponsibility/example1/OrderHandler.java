package leetcode.designPatterns.behaviourial.chainOfResponsibility.example1;

public abstract class OrderHandler {

    protected OrderHandler orderHandler;

    public OrderHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    public abstract void processOrder(String order);
}
