package leetcode.principles.ThreadStates;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t3=new Thread(()->{
            try {
                Thread.sleep(1);
                for(int i=1000;i>0;i--);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },"states");
        t3.start();

        //t3.yield(); //put again into ready to run state but JVM decides whether it has to obey opr not
        //t3.interrupt(); //interrupts the sleeping or waiting thread and results in exception

        while(true){
            Thread.State state=t3.getState();
            System.out.println(state);
            if(state==Thread.State.TERMINATED) break;
        }
    }
}
