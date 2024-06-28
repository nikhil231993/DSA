package leetcode.designPatterns.factoryMethod;

public class CriticalLoggerFactory implements ILoggerFactory {

    @Override
    public ILogger loggerInstance() {
        return new CriticalLogger();
    }
}
