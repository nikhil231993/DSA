package leetcode.designPatterns.creational.factoryMethod;

public class CriticalLogger implements ILogger{

    @Override
    public void log() {
        System.out.println("CRITICAL Logger");
    }
}
