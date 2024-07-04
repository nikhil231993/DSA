package leetcode.designPatterns.behaviourial.iterator;

import java.util.ArrayList;
import java.util.List;

public class Inventory { // This is the aggregate class that stores the product and provides an iterator

    private List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator createIterator(){
        return new ProductIterator(products);
    }
}
