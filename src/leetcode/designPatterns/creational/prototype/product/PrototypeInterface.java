package leetcode.designPatterns.creational.prototype.product;

public interface PrototypeInterface {

    PrototypeInterface clonePrototype();

    void update(int price);

    void display();
}
