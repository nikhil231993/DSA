package leetcode.designPatterns.creational.singleton.example2;

public class SingletonMain {

    //1. we want one instance so constructor should be private
    //2. static instance
    //3. static getter
    //4. final class so subclass also cannot create instance using Reflections

    public static void main(String[] args) {

        Singleton singleton1= Singleton.getInstance();
        System.out.println(singleton1.hashCode());

        Singleton singleton2= Singleton.getInstance();
        System.out.println(singleton2.hashCode());
    }
}
