package leetcode.designPatterns.creational.singleton.example1Eager;

public class Main {

    public static void main(String[] args) {

        Singleton.someStaticMethod();
        System.out.println(Singleton.getInstance());
    }
}
