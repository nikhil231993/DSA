package leetcode.principles.ThreadStates.joinTest;

public class Main {

    public static void main(String[] args) {

        //if we call thread.join() then the program will wait for that thread to complete then only it will complete
        //ie all the child threads of Main will complete first and then main will start
        Thread thread=new Thread(()->{
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "our thread");

        thread.start();

        Thread thread2=new Thread(()->{
            System.out.println(Thread.currentThread());
        }, "our thread-2");

        thread2.start();


        try {

            thread.join();// due to this system will stop till this also completes
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        System.out.println("Main waiting");
    }
}
