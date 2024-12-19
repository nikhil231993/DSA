package leetcode.designPatterns.creational.singleton.example1Eager;

public class Main {

    public static void main(String[] args) {

        Singleton.someStaticMethod();
        System.out.println(Singleton.getInstance());

        //Below we have used static block for eager initialization
        SingletonStaticBlock s=SingletonStaticBlock.INSTANCE;
        System.out.println(s);
    }
}
