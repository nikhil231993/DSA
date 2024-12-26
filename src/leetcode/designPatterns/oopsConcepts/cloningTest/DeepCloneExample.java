package leetcode.designPatterns.oopsConcepts.cloningTest;

public class DeepCloneExample {
    public static void main(String[] args) {
        Address address = new Address("New York", "NY");
        Person original = new Person("Alice", address);

        // Create a deep clone
        Person deepClone = original.deepClone();

        // Modify the clone's address
        deepClone.address.city = "Los Angeles";

        System.out.println("Original: " + original);
        System.out.println("Deep Clone: " + deepClone);
    }
}

