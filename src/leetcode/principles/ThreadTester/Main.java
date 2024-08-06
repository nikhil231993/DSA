package leetcode.principles.ThreadTester;

import leetcode.principles.ThreadTester.RunnableInterface.Thread2;

public class Main {

    public static void main(String[] args) {

        //POINTS:
        // 1. Thread t1 and t2 can execute in any order
        // 2. Both are user thread
        // 3. Use setDaemon(true) to start user thread as daemon thread

        System.out.println("Starting userthread");
        Thread t1=new Thread1("Thread 111");
        //t1.setDaemon(true);
        t1.start();

        Thread t2=new Thread(new Thread2(), "Thread2");
        t2.start();

        System.out.println("Exiting userthread");
    }
}
