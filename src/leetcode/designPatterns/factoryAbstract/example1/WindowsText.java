package leetcode.designPatterns.factoryAbstract.example1;

public class WindowsText implements ITextBox {

    @Override
    public void textPressed() {
        System.out.println("Windows Text Pressed");
    }
}
