package leetcode.designPatterns.oopsConcepts.abstractClasses;

public class Driver{

    public static void main(String[] args) {

        Car c=new Car();
        c.display();
        c.show();
        c.running();

        Vehicle.running();
    }
}
