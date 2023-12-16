package leetcode.designPatterns.factorySimple;

public class ILoggerFactory {

    public ILogger getCourseFactory(String course){
        if(course.trim().equalsIgnoreCase("DEBUG"))
            return new DebugLogger();
        else if(course.trim().equalsIgnoreCase("ERROR"))
            return new ErrorLogger();
        else
            return new InfoLogger();
    }
}
