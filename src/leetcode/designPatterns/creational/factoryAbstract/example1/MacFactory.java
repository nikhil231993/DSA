package leetcode.designPatterns.creational.factoryAbstract.example1;

public class MacFactory implements IFactory {

    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacText();
    }
}
