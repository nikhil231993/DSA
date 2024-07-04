package leetcode.designPatterns.creational.singleton.example2;

public class SingletonMain {

    public static void main(String[] args) {

            Singleton singleton1= Singleton.getInstance();
            singleton1.setName("Nikhil");
            System.out.println(singleton1.hashCode());
            System.out.println(singleton1.getName());

            Singleton singleton2= Singleton.getInstance();
            singleton2.setName("Rahul");
            System.out.println(singleton2.hashCode());
            System.out.println(singleton2.getName());

            System.out.println(singleton1.getName());
    }
}
