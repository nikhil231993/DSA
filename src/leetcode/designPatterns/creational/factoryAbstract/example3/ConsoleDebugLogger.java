package leetcode.designPatterns.creational.factoryAbstract.example3;

public class ConsoleDebugLogger implements DebugLogger{

    @Override
    public void debugDisplay() {
        System.out.println("Console Debug Logger");
    }
}
