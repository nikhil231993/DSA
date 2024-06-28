package leetcode.designPatterns.factorySimple;

public class ErrorLogger implements ILogger{

    @Override
    public void log() {
        System.out.println("Error log");
    }
}
