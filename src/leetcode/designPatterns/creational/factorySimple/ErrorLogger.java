package leetcode.designPatterns.creational.factorySimple;

public class ErrorLogger implements ILogger{

    @Override
    public void log() {
        System.out.println("Error log");
    }
}
