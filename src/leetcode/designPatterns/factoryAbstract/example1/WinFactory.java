package leetcode.designPatterns.factoryAbstract.example1;

public class WinFactory implements IFactory {

    @Override
    public IButton createButton() {
        return new WinButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WindowsText();
    }
}
