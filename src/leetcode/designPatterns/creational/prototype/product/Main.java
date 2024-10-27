package leetcode.designPatterns.creational.prototype.product;

public class Main {

    public static void main(String[] args) {

            Prototype product1=new ProductPrototype("Cap", "Esacpe from sun", 100);
            Prototype product2=product1.clonePrototype();
            product1.update(200);
            product1.update(1000);

            System.out.println("Product 1: ");
            product1.display();
            System.out.println("Product 2: ");
            product2.display();
    }
}
