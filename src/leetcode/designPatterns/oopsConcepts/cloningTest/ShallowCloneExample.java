package leetcode.designPatterns.oopsConcepts.cloningTest;

public class ShallowCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address("New York", "NY");
        Person original = new Person("Alice", address);

        // Create a shallow clone
        Person shallowClone = (Person) original.clone();

        // Modify the clone's address
        shallowClone.address.city = "Los Angeles";

        System.out.println("Original: " + original);
        System.out.println("Shallow Clone: " + shallowClone);
    }
}
