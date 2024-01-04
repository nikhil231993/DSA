package leetcode.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator createIterator(){
        return new ProductIterator(products);
    }
}
