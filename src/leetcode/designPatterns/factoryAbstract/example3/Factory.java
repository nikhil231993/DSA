package leetcode.designPatterns.factoryAbstract.example3;

public class Factory {

    public static LoggerFactory createFactory(String name){
        switch (name){
            case "console":
                return new ConsoleLoggerFactory();
            case "file":
                return new FileLoggerFactory();
        }
        return null;
    }
}
