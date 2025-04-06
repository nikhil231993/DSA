package leetcode.designPatterns.creational.singleton.example1Eager;

public class SingletonStaticBlock {

    // Eager initialization of the singleton instance
    public static SingletonStaticBlock INSTANCE = null;

    // Private constructor to prevent instantiation
    private SingletonStaticBlock() {
        System.out.println("Singleton instance created");
    }

    // Public method to access the singleton instance
    static {
        INSTANCE=new SingletonStaticBlock();
    }

    // Static method to demonstrate other static behaviors
    public static void someStaticMethod() {
        System.out.println("Some static method called");
    }
}
