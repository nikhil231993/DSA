package leetcode.designPatterns.factorySimple;

public class FactoryMain {

    //client -> as here we create object in factory but client only uses it
    public static void main(String[] args) {

        LoggerFactory courseFactory=new LoggerFactory();
        ILogger course1=courseFactory.getCourseFactory("INFO");
        //Since we use ILogger then it follows DIP
        //OCP is followed as new loggers can be easily created in factory
        //client does not make any changes
        //SRP is followed by each class doing something specific
        //LSP is followed as we can use DebugLogger instead of ILogger
        course1.log();

        ILogger course2=courseFactory.getCourseFactory("DEBUG");
        course2.log();

        ILogger course3=courseFactory.getCourseFactory("ERROR");
        course3.log();
    }
}
