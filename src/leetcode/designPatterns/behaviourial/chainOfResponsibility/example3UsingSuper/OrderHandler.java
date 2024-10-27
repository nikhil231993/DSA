package leetcode.designPatterns.behaviourial.chainOfResponsibility.example3UsingSuper;

public abstract class OrderHandler {

    public OrderHandler orderHandler;

    public abstract void processOrder(String order);

    public void setHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }
}
