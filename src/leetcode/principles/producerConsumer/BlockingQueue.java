package leetcode.principles.producerConsumer;

import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int cap){
        q=new LinkedList<>();
        capacity=cap;
    }

    public boolean add(int value){
        synchronized (this){
            //if is replaced with while to avoid condition of where adder2 goes and inserts in queue
            while(q.size()==capacity){
                try {
                    this.wait(); //adder1, adder2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(value);
            System.out.println("Added value:"+10);
            this.notifyAll();
            return true;
        }
    }

    public int remove(){
        synchronized (this){
            while(q.isEmpty()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int n=q.poll();
            System.out.println("Removed value:" +10);
            this.notifyAll();
            return n;
        }
    }
}
