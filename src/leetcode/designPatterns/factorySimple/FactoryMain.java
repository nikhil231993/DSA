package leetcode.designPatterns.factorySimple;

public class FactoryMain {
    //client -> as here we create object in factory but client only uses it
    public static void main(String[] args) {

        ILoggerFactory courseFactory=new ILoggerFactory();
        ILogger course1=courseFactory.getCourseFactory("INFO");
        course1.log();

        ILogger course2=courseFactory.getCourseFactory("DEBUG");
        course2.log();

        ILogger course3=courseFactory.getCourseFactory("ERROR");
        course3.log();
    }
}
