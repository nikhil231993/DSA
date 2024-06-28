package leetcode.designPatterns.factoryAbstract.example3;

public class ConsoleLoggerFactory implements LoggerFactory{

    @Override
    public DebugLogger createDebugLogger() {
        return new ConsoleDebugLogger();
    }

    @Override
    public ErrorLogger createErrorLogger() {
        return new ConsoleErrorLogger();
    }

    @Override
    public InfoLogger createInfoLogger() {
        return new ConsoleInfoLogger();
    }
}
