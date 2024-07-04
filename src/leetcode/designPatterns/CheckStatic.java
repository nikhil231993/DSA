package leetcode.designPatterns;

public class CheckStatic {

    private static CheckStatic checkStatic;

    static {
        System.out.println("Static");
        checkStatic=new CheckStatic();
    }

    public static  CheckStatic  getInstance(){
        System.out.println("test");
        return checkStatic;
    }
}
