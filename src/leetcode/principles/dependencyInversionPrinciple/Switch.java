package leetcode.principles.dependencyInversionPrinciple;

public class Switch {

    public Switchable switchable;

    public Switch(Switchable switchable){
        this.switchable=switchable;
    }

    public void turnOff(){
        this.switchable.turnOff();
    }

    public void tunrOn(){
        this.switchable.turnOn();
    }
}
