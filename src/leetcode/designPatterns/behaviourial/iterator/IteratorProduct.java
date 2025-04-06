package leetcode.designPatterns.behaviourial.iterator;

public interface IteratorProduct<T> {

    Product first();

    Product next();

    boolean hasNext();
}
