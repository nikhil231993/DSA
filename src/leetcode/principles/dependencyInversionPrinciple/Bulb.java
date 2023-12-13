package leetcode.principles.dependencyInversionPrinciple;

public class Bulb implements Switchable{
    @Override
    public void turnOff() {
        System.out.println("Bulb turned off");
    }

    @Override
    public void turnOn() {
        System.out.println("Bulb turned on");
    }
}
