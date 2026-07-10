package leetcode.designPatterns.deadlock;

public class DeadLock {

    String a= "Nikhil";
    String b="Kavya";

    public void first() throws InterruptedException{
        synchronized (a){
            Thread.sleep(10);
            synchronized (b){
                Thread.sleep(100);
            }
        }
    }

    public void second() throws InterruptedException{
        synchronized (b){
            Thread.sleep(10);
            synchronized (a){
                Thread.sleep(100);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock lock=new DeadLock();
        new Thread(()->{
            try {
                lock.first();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            try {
                lock.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
