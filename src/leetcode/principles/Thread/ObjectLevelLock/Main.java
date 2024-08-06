package leetcode.principles.Thread.ObjectLevelLock;

public class Main {

    public static void main(String[] args) {

        Employee e=new Employee();

        Thread t1=new Thread(()->e.display());
        t1.start();

        Thread t2=new Thread(()->e.show());
        t2.start();
    }
}
