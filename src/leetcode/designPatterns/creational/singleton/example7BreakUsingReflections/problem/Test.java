package leetcode.designPatterns.creational.singleton.example7BreakUsingReflections.problem;

import java.lang.reflect.Constructor;

class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {}  // Private constructor

    public static Singleton getInstance() {
        return instance;
    }
}

public class Test {

    public static void main(String[] args) throws Exception {

        Singleton instance1 = Singleton.getInstance();

        // Accessing private constructor via reflection
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);  // Make private constructor accessible
        Singleton instance2 = constructor.newInstance();

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println("Same instance ? " + (instance1 == instance2));
    }
}

