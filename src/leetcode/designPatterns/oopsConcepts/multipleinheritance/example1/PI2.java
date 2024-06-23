package leetcode.designPatterns.oopsConcepts.multipleinheritance.example1;

public interface PI2 {

    default void show() {

        // Print statement if method is called
        // from interface 2
        System.out.println("Default PI2");
    }
}
