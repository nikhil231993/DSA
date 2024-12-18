package leetcode.designPatterns.creational.singleton.example9Enum;

enum Singleton {

    //      How It Works:
    //      1. enum in Java guarantees that there will be only one instance of each constant. Here, INSTANCE is the only instance.
    //      2. Java handles serialization of enums internally, ensuring that the same instance is returned
    //         even after deserialization.
    //      3. Reflection safety: You cannot use reflection to create another instance of an enum, as it throws an
    //         exception (IllegalArgumentException).

    //    Why Use Enum for Singleton?
    //    1.Thread-Safety: Enums are inherently thread-safe.
    //    2.Serialization Safety: No need for readResolve() to ensure the same instance.
    //    3.Reflection Protection: Enums cannot be instantiated via reflection.
    //    4.Simplicity: Very concise and readable.

    INSTANCE;  // The single instance

    // Add any fields or methods as needed
    public void doSomething() {
        System.out.println("Singleton instance is doing something!");
    }
}

public class Test {

    public static void main(String[] args) {

        // Access the singleton instance
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        System.out.println("Same instance? " + (instance1 == instance2));  // true

        // Use the method
        instance1.doSomething();
    }
}

