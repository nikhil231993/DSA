package leetcode.designPatterns.creational.singleton.example3.threeInstance;

public class Singleton {

    private String name;
    private static int id=1;

    private static Singleton singleton=null;

    private Singleton(){
        id++;
    }

    public static Singleton getInstance(){

        if(id<=3){
            synchronized (Singleton.class){
                if(id<=3){
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
