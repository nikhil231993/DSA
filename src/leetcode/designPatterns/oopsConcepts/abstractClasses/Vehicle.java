package leetcode.designPatterns.oopsConcepts.abstractClasses;

public abstract class Vehicle {

    void show(){
        System.out.println("Vehicle");
    }

    abstract void display();

    static void running(){
        System.out.println("Vehicle running");
    }
}
