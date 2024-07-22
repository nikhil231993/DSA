package leetcode.designPatterns.oopsConcepts.interfacePackage;

public class Car implements Vehicle{

    @Override
    public void display() {
        System.out.println("Car display");
    }

    public static void showCar(){
        Vehicle.print();
    }
}
