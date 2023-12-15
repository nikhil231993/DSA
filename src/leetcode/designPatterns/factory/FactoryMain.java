package leetcode.designPatterns.factory;

public class FactoryMain {

    public static void main(String[] args) {
        CourseFactory courseFactory=new CourseFactory();
        Course course1=courseFactory.getCourseFactory("LIVE");
        course1.display();

        Course course2=courseFactory.getCourseFactory("OFFLINE");
        course2.display();

        Course course3=courseFactory.getCourseFactory("RECORDED");
        course3.display();
    }
}
