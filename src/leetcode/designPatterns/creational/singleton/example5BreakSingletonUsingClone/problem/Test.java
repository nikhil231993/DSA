package leetcode.designPatterns.creational.singleton.example5BreakSingletonUsingClone.problem;

class Singleton implements Cloneable {

    private static final Singleton instance = new Singleton();  // Eager Initialization

    private Singleton() {}  // Private constructor to prevent instantiation

    public static Singleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Creates a new instance via cloning
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = (Singleton) instance1.clone();  // Breaks singleton!

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println("Same instance? " + (instance1 == instance2));
    }
}
