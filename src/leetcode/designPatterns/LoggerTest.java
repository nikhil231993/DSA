package leetcode.designPatterns;

public class LoggerTest extends Test {

    private String name;

    public static void display(String name){
        System.out.println(name);
    }

    public LoggerTest(String name) {
        //super(name);
        System.out.println("Test");
    }
}
