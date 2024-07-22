package leetcode.designPatterns;

public interface Test1{

    default void show(){
        System.out.println("show");
    }

    public static void display(){
        System.out.println("Display");
    }
}
