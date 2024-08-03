package leetcode.designPatterns.behaviourial.chainOfResponsibility.example1;

public abstract class OrderHandler {

    protected OrderHandler orderHandler;
    //Because of this we have aggregation and since we call another handler from one concrete handler
    //we have association also

    public OrderHandler(OrderHandler orderHandler){
        this.orderHandler=orderHandler;
    }

    public abstract void processOrder(String order);
}
