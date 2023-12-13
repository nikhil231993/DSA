package leetcode.principles.dependencyInversionPrinciple;

public class Main {

    public static void main(String[] args) {
        Bulb bulb=new Bulb();
        Fan fan=new Fan();

        Switch bulbSwitch=new Switch(bulb);
        Switch fanSwitch=new Switch(fan);

        bulbSwitch.turnOff();
        bulbSwitch.tunrOn();

        fanSwitch.turnOff();
        fanSwitch.tunrOn();
    }
}
