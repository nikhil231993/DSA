package leetcode.designPatterns.creational.factoryMethod;

public class InfoLoggerFactory implements ILoggerFactory{

    @Override
    public ILogger loggerInstance() {
        return new InfoLogger();
    }
}
