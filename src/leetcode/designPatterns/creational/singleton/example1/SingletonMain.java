package leetcode.designPatterns.creational.singleton.example1;

public class SingletonMain {

    //1. we want one instance so constructor should be private
    //2. static instance
    //3. static getter

    public static void main(String[] args) {

        Singleton singleton1= Singleton.getInstance();
        System.out.println(singleton1.hashCode());

        Singleton singleton2= Singleton.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
