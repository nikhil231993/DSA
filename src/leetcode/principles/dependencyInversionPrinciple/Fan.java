package leetcode.principles.dependencyInversionPrinciple;

public class Fan implements Switchable{
    @Override
    public void turnOff() {
        System.out.println("Fan turned off");
    }

    @Override
    public void turnOn() {
        System.out.println("Fan turned off");
    }
}
