package leetcode.principles.ThreadStates.deadlocks;

public class DeadLocks {

    //Order in which both the thread acquire the lock should be same to create deadlock

    String lock1="Nikhil";
    String lock2="Test";

    public void push(){
        synchronized (lock1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2){
                System.out.println("Reached pushed");
            }
        }
    }

    public void pop(){
        synchronized (lock1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2){
                System.out.println("Reached pop");
            }
        }
    }

    public static void main(String[] args) {

        DeadLocks d=new DeadLocks();

        System.out.println("Main starting");

        new Thread(()->{
            d.push();
        }).start();

        new Thread(()->{
            d.pop();
        }).start();

        System.out.println("Main Ended");
    }
}
