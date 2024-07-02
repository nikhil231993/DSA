package leetcode.designPatterns.prototype.product;

public class Main {

    public static void main(String[] args) {

            Prototype product1=new ProdcutPrototype("Cap", "Esacpe from sun", 100);
            Prototype prodcut2=product1.clonePrototype();
            product1.update(200);
            product1.update(1000);
            product1.display();
            prodcut2.display();
    }
}
