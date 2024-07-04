package leetcode.designPatterns.creational.factoryAbstract.example1;

public class MacText implements ITextBox {

    @Override
    public void createTextBox() {
        System.out.println("Mac Text Pressed");
    }
}
