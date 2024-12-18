package leetcode.designPatterns.creational.singleton.example1Eager;

public class Singleton {

    // Eager initialization of the singleton instance
    private static final Singleton INSTANCE = new Singleton();

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Public method to access the singleton instance
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // Static method to demonstrate other static behaviors
    public static void someStaticMethod() {
        System.out.println("Some static method called");
    }
}
