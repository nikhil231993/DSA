package leetcode.principles.Thread.ClassLevelLock;

public class Employee {

    //1. If inside the synchronized block we use the same object then even though they are executed using diff threads they cannot run parallely
    //2. but if the objects are different then they can executed by any thread and also in parallel

    public static void display(){
        synchronized (Employee.class) {
            System.out.println("Display");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void show(){

        synchronized (Employee.class) {
            System.out.println("Show");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
