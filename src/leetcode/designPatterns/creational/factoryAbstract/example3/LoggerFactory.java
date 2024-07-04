package leetcode.designPatterns.creational.factoryAbstract.example3;

public interface LoggerFactory {

    DebugLogger createDebugLogger();

    ErrorLogger  createErrorLogger();

    InfoLogger createInfoLogger();
}
