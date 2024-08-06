package leetcode.principles.ThreadTester.RunnableInterface;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main starting");
        Thread thread=new Thread(new Thread2());
        thread.start();
        System.out.println("Main exiting");
    }
}
