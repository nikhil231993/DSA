package leetcode.designPatterns.behaviourial.iterator;

public class Main {

    public static void main(String[] args) {

        Product product1=new Product("Jacket", 100.00);
        Product product2=new Product("Laptop", 1100.00);
        Product product3=new Product("Shoe", 200.00);

        InventoryAggregator inventory=new InventoryAggregator();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        IteratorProduct iterator = inventory.createIterator();
        Product pr = iterator.first();

        while(pr!=null){
            System.out.println(pr.getName() + "    " +pr.getPrice());
            pr=iterator.next();
        }
    }
}
