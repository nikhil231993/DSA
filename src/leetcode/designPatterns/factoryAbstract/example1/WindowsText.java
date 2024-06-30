package leetcode.designPatterns.factoryAbstract.example1;

public class WindowsText implements ITextBox {

    @Override
    public void createTextBox() {
        System.out.println("Windows Text Pressed");
    }
}
