package leetcode.designPatterns.factoryMethod;

public class Main {

    public static void main(String[] args) {
        ILoggerFactory info=new InfoLoggerFactory();
        ILogger log=info.loggerInstance();
        log.log();

        ILoggerFactory error=new ErrorLoggerFactory();
        ILogger error1=error.loggerInstance();
        error1.log();

        ILoggerFactory debug=new DebugLoggerFactory();
        ILogger debug1=debug.loggerInstance();
        debug1.log();
    }
}
