package leetcode.designPatterns.creational.singleton.example4InnerClass;

public class Main {

    public static void main(String[] args) {

        Singleton singleton=Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1);
    }
}
