package leetcode.principles.producerConsumer;

public class Main {

    public static void main(String[] args) {

        BlockingQueue b=new BlockingQueue(10);

        for(int i=0;i<10;i++){
            Thread t1=   new Thread(()->{
                   b.add(10);
               });
             t1.start();

            Thread t2=new Thread(()->{
                b.remove();
            });
            t2.start();
           // t2.interrupt();
        }
    }
}
