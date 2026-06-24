package leetcode.designPatterns.behaviourial.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);


        while(list.iterator().hasNext()) {
            System.out.println(list.iterator().next());
        }

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
