package leetcode.designPatterns.factoryAbstract.example3;

public class FileLoggerFactory implements LoggerFactory{
    @Override
    public DebugLogger createDebugLogger() {
        return new FileDebugLogger();
    }

    @Override
    public ErrorLogger createErrorLogger() {
        return new FileErrorLogger();
    }

    @Override
    public InfoLogger createInfoLogger() {
        return new FileInfoLogger();
    }
}
