package leetcode.designPatterns.creational.factoryAbstract.example1;

public class MacButton implements IButton {

    @Override
    public void buttonPressed() {
        System.out.println("Mac Button Pressed");
    }
}
