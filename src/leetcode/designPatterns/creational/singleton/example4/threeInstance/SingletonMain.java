package leetcode.designPatterns.creational.singleton.example4.threeInstance;

public class SingletonMain {

    public static void main(String[] args) {

            Singleton singleton1= Singleton.getInstance();
            singleton1.setName("Nikhil");
            System.out.println(singleton1.hashCode());
            System.out.println(singleton1.getName());

            Singleton singleton2= Singleton.getInstance();
            singleton2.setName("Rahul");
            System.out.println(singleton2.hashCode());

            System.out.println("Singleton 2: ");
            System.out.println(singleton2.getName());
            System.out.println("Singleton 1: ");
            System.out.println(singleton1.getName());

            Singleton singleton3= Singleton.getInstance();
            System.out.println(singleton3.hashCode());
            Singleton singleton4= Singleton.getInstance();
            System.out.println(singleton4.hashCode());
            Singleton singleton5= Singleton.getInstance();
            System.out.println(singleton5.hashCode());
    }
}
