package leetcode.designPatterns.chainOfResponsibility.example2;

public abstract class OrderHandler {

    public abstract void processOrder(String order);

    public abstract void setHandler(OrderHandler orderHandler); // This is added to make sure you concrete implementations implement it
}
