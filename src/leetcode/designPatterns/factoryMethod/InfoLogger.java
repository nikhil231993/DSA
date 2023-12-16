package leetcode.designPatterns.factoryMethod;

public class InfoLogger implements ILogger {
    @Override
    public void log() {
        System.out.println("INFO Logger");
    }
}
