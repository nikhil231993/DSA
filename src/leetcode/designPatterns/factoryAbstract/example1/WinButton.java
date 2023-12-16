package leetcode.designPatterns.factoryAbstract.example1;

public class WinButton implements IButton {
    @Override
    public void buttonPressed() {
        System.out.println("Windows button pressed");
    }
}
