package leetcode.designPatterns.creational.factoryMethod;

public class DebugLoggerFactory implements ILoggerFactory {

    @Override
    public  ILogger loggerInstance() {
        return new DebugLogger();
    }
}
