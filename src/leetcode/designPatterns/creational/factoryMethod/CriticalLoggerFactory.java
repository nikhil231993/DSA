package leetcode.designPatterns.creational.factoryMethod;

public class CriticalLoggerFactory implements ILoggerFactory {

    @Override
    public ILogger loggerInstance() {
        return new CriticalLogger();
    }
}
