package leetcode.designPatterns.factoryAbstract.example1;

public interface IFactory {

    IButton createButton();

    ITextBox createTextBox();
}
