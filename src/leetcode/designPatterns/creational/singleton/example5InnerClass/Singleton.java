package leetcode.designPatterns.creational.singleton.example5InnerClass;

public class Singleton {

    private Singleton(){
        if(InnerSingleton.instance!=null)
            throw new IllegalStateException("Instance already created");
    }

    private static class InnerSingleton{
        private static final Singleton instance=new Singleton();
    }

    public static Singleton getInstance(){
        return InnerSingleton.instance;
    }
}
