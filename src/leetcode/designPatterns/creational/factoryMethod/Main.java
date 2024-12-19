package leetcode.designPatterns.creational.factoryMethod;

public class Main {

    public static void main(String[] args) {

        ILoggerFactory info = new InfoLoggerFactory();
        ILogger log=info.loggerInstance();
        log.log();

        ILoggerFactory error = new ErrorLoggerFactory();
        ILogger error1=error.loggerInstance();
        error1.log();

        ILoggerFactory debug = new DebugLoggerFactory();
        ILogger debug1=debug.loggerInstance();
        debug1.log();

        ILoggerFactory critical = new CriticalLoggerFactory();
        ILogger critical1=critical.loggerInstance();
        critical1.log();

        //In simple factory there was an issue of OCP in CreateFactory as we had to had another if else or switch condition
        //to add new logger which we solved here by another abstraction of LoggerFactory

        //Now if we want FatalLogger only 3 steps are need
        //1. extend ILogger and create FatalLogger
        //2. ILoggerFactory and create FatalLoggerFactory and return ILogger instance of type FatalLogger
        //3. pass new input in this class
    }
}
