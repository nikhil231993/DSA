package leetcode.designPatterns.creational.factoryMethod;

public class ErrorLogger implements ILogger{

    @Override
    public void log() {
        System.out.println("ERROR Logger");
    }
}
