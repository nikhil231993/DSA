package leetcode.designPatterns.creational.factoryAbstract.example3;

public class ConsoleErrorLogger implements ErrorLogger{

    @Override
    public void errorDisplay() {
        System.out.println("Console Error Logger");
    }
}
