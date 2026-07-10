package leetcode.designPatterns.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    Queue<Integer> q=new LinkedList<>();
    int capacity=10;

    public synchronized  void producer(int num) throws InterruptedException{

        while(q.size()==capacity)
            wait();
        System.out.println("Item : "+ num+ "has been added to queue");
        q.offer(num);
        notify();
    }

    public synchronized void consumer() throws InterruptedException{

        while(q.isEmpty())
            wait();
        System.out.println("Item : "+ q.peek() + "has been removed from queue");
        q.poll();
        notify();
    }
}

class QueueMain {

    public static void main(String[] args) {
    QueueExample queueExample=new QueueExample();
    new Thread(()->{
        while(true){
            for (int i=0;i<10;i++){
                try {
                    queueExample.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }).start();

    new Thread(()->{
        while (true){
            try {
                queueExample.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();
    }
}
