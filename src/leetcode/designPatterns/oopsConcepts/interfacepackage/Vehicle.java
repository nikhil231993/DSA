package leetcode.designPatterns.oopsConcepts.interfacepackage;

public interface Vehicle {

    default void show(){
        System.out.println("Vehicle");
    }

    void display();
}
