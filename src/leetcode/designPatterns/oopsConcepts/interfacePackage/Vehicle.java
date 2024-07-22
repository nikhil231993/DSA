package leetcode.designPatterns.oopsConcepts.interfacePackage;

public interface Vehicle {

    default void show(){
        System.out.println("Interface Vehicle");
    }

    void display();

    public static void print(){
        System.out.println("Interface print");
    }
}
