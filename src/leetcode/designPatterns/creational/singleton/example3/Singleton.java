package leetcode.designPatterns.creational.singleton.example3;

public class Singleton {

    private String name;

    private static Singleton singleton=null;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
