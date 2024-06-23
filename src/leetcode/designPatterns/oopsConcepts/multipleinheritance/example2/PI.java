package leetcode.designPatterns.oopsConcepts.multipleinheritance.example2;

public interface PI {

    default void show(){
        System.out.println("Grandparents");
    }
}
