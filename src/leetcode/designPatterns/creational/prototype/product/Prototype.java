package leetcode.designPatterns.creational.prototype.product;

public abstract class Prototype {

    public abstract Prototype clonePrototype();

    public abstract void update(int price);

    public abstract void display();
}
