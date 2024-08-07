package leetcode.principles.ThreadUsingStack.problem;

public class Main {

    public static void main(String[] args) {

        StackImplementation st=new StackImplementation(10);

        System.out.println("Main statring");
        new Thread(()->{
            int count=0;
            while(++count<10)
                System.out.println("Pushed: "+ st.push(100));
        },"Pusher").start();

        new Thread(()->{
            int count=0;
            while(++count<10)
                System.out.println("Popped: " +st.pop());
        }, "popper").start();

        System.out.println("Main is exiting");
    }

}
