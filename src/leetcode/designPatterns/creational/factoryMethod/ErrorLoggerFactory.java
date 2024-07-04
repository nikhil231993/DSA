package leetcode.designPatterns.creational.factoryMethod;

public class ErrorLoggerFactory implements ILoggerFactory{

    @Override
    public ILogger loggerInstance() {
        return new ErrorLogger();
    }
}
