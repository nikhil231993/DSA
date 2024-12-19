package leetcode.designPatterns.creational.prototype.product;

public abstract class PrototypeAbstractClass {

    public abstract PrototypeAbstractClass clonePrototype();

    public abstract void update(int price);

    public abstract void display();
}
