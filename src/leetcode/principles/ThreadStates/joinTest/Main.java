package leetcode.principles.ThreadStates.joinTest;

public class Main {

    public static void main(String[] args) {

        //if we call thread.join() then the program will wait for that thread to complete then only it will complete
        //ie all the child threads of Main will complete first and then main will start
        Thread thread=new Thread(()->{
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(100000);
                System.out.println("our thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "our thread");

        thread.start();

        Thread thread2=new Thread(()->{
            System.out.println(Thread.currentThread());
            System.out.println("our thread-2");
        }, "our thread-2");

        thread2.start();

        // Due to below join()s this system will stop till this also completes
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main waiting");
    }
}
