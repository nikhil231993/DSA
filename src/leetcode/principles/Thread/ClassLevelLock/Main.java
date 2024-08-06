package leetcode.principles.Thread.ClassLevelLock;

public class Main {

    public static void main(String[] args) {

        Thread t1=new Thread(()-> Employee.display());
        t1.start();

        Thread t2=new Thread(()->Employee.show());
        t2.start();
    }
}
