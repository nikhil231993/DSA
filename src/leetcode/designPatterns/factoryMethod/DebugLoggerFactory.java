package leetcode.designPatterns.factoryMethod;

public class DebugLoggerFactory implements ILoggerFactory {

    @Override
    public  ILogger loggerInstance() {
        return new DebugLogger();
    }
}
