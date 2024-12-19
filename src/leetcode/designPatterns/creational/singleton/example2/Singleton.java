package leetcode.designPatterns.creational.singleton.example2;

public class Singleton {

    //https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

    private static Singleton singleton=null; // Volatile ensures visibility
    //volatile can be used but is not mandatory

    private Singleton(){
        if(singleton!=null)
            throw new IllegalArgumentException();
    }

    public static Singleton getInstance(){

        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
