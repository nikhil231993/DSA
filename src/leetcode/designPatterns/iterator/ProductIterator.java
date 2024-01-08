package leetcode.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class ProductIterator implements Iterator{

    private List<Product> products =new ArrayList<>();
    private int count=0;

    public ProductIterator(List<Product> products){
        this.products=products;
    }

    @Override
    public Product first() {
        if (products.isEmpty()) {
            return null;
        }
        count = 0;
        return products.get(count);
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return products.get(++count);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return count < products.size() - 1;
    }
}
