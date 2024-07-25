package leetcode.principles.InterfaceDemo;

public class MainCar implements  Car{

    public static void main(String[] args) {

        Car c=new MainCar();
        c.startTest();
        c.print();
        Car.starting();
    }

    @Override
    public void print() {
        Car.start();
        Car.starting();
    }
}
