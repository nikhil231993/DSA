package leetcode.designPatterns.oopsConcepts.abstractclasses;

public class Driver{

    public static void main(String[] args) {

        Car c=new Car();
        c.display();
        c.show();
        c.running();

        Vehicle.running();
    }
}
