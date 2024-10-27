package leetcode.designPatterns.creational.singleton.example4InnerClass;

public class Singleton {

    private Singleton(){
    }

    private static class InnerSingleton{
        private static Singleton instance=new Singleton();
    }

    public static Singleton getInstance(){
        return InnerSingleton.instance;
    }
}
