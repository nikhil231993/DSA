package leetcode.designPatterns.creational.prototype.product;

public class Main {

    public static void main(String[] args) {

            Prototype product1=new ProdcutPrototype("Cap", "Esacpe from sun", 100);
            Prototype prodcut2=product1.clonePrototype();
            product1.update(200);
            product1.update(1000);

            System.out.println("Product 1: ");
            product1.display();
            System.out.println("Product 2: ");
            prodcut2.display();
    }
}
