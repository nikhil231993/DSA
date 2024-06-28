package leetcode.designPatterns.factoryAbstract.example1;

public class MacText implements ITextBox {

    @Override
    public void textPressed() {
        System.out.println("Mac Text Pressed");
    }
}
