package leetcode.designPatterns.singleton.example1;

public class SingletonMain {

    public static void main(String[] args) {

            Singleton singleton1= Singleton.getInstance();
            System.out.println(singleton1.hashCode());

            Singleton singleton2= Singleton.getInstance();
            System.out.println(singleton2.hashCode());
    }
}
