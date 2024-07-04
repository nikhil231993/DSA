package leetcode.designPatterns.creational.factoryMethod;

public class DebugLogger implements ILogger{

    @Override
    public void log() {
        System.out.println("DEBUG Logger");
    }
}
