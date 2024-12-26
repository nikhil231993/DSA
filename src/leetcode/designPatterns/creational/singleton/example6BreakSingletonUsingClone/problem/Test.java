package leetcode.designPatterns.creational.singleton.example6BreakSingletonUsingClone.problem;

import java.util.ArrayList;
import java.util.List;

class Singleton implements Cloneable {

    private String name="Nikhil";
    public List<String> list=new ArrayList<>();

    private static final Singleton instance = new Singleton();  // Eager Initialization

    private Singleton() {}  // Private constructor to prevent instantiation

    public static Singleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Creates a new instance via cloning
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = (Singleton) instance1.clone();  // Breaks singleton!

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println("Same instance ? " + (instance1 == instance2));

        System.out.println("Chaining values");
        instance1.setName("Kavya");
        System.out.println("Instance 1 :"+ instance1.getName());
        System.out.println("Instance 2 :"+ instance2.getName());

        System.out.println("Refernce list");
        instance1.list.add("Lam");
        System.out.println("Instance 1 :"+ instance1.list);
        System.out.println("Instance 2 :"+ instance2.list);
        instance2.list.add("Amazon");
        System.out.println("Instance 1 :"+ instance1.list);
        System.out.println("Instance 2 :"+ instance2.list);
    }
}
