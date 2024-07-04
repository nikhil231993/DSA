package leetcode.designPatterns.creational.factorySimple;

public class LoggerFactory {

    public ILogger getCourseFactory(String course){

        if(course.trim().equalsIgnoreCase("DEBUG"))
            return new DebugLogger();
        else if(course.trim().equalsIgnoreCase("ERROR"))
            return new ErrorLogger();
        else
            return new InfoLogger();
    }
}
