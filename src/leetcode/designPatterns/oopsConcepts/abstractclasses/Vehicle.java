package leetcode.designPatterns.oopsConcepts.abstractclasses;

public abstract class Vehicle {

    void show(){
        System.out.println("Vehicle");
    }

    abstract void display();

    static void running(){
        System.out.println("Vehicle running");
    }
}
