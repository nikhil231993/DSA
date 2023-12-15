package leetcode.designPatterns.factory;

public class CourseFactory {

    public Course getCourseFactory(String course){
        if(course.trim().equalsIgnoreCase("LIVE"))
            return new LiveCourse();
        else if(course.trim().equalsIgnoreCase("Recorded"))
            return new RecordedCourse();
        else
            return new OfflineCourse();
    }
}
