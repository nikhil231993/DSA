package leetcode.designPatterns.oopsConcepts.multipleinheritance.example1;

public interface PI1 {

    default void show()
    {

        // Print statement if method is called
        // from interface 1
        System.out.println("Default PI1");
    }
}
