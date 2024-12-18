package leetcode.designPatterns.creational.singleton.example5InnerClass;

public class Main {

    public static void main(String[] args) {

        Singleton singleton=Singleton.getInstance();
        System.out.println(singleton);
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1);
    }
}
