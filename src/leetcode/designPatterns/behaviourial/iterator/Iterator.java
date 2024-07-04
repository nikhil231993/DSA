package leetcode.designPatterns.behaviourial.iterator;

public interface Iterator<T> {

    Product first();

    Product next();

    boolean hasNext();
}
