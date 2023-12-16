package leetcode.designPatterns.factoryMethod;

public class InfoLoggerFactory implements ILoggerFactory{

    @Override
    public ILogger loggerInstance() {
        return new InfoLogger();
    }
}
