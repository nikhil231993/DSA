package leetcode.designPatterns.iterator;

public interface Iterator {

    Product first();

    Product next();

    boolean hasNext();
}
