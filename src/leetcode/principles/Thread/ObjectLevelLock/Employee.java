package leetcode.principles.Thread.ObjectLevelLock;

public class Employee {

    //1. If inside the synchronized block we use the same object then even though they are executed using diff threads they cannot run parallely
    //2. but if the objects are different then they can executed vy any thread and also in parallel
    //3. StingBuffer is a Thread safe class wheres StingBuilder is not

    public void display(){
        synchronized (this) {
            System.out.println("Display");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void show(){

        synchronized (this) {
            System.out.println("Show");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
