package leetcode.designPatterns.oopsConcepts.multipleinheritance.grandFatherInterface;

public interface PI {

    default void show(){
        System.out.println("Grandparents");
    }
}
