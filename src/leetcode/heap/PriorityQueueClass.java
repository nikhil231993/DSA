package leetcode.heap;

import java.util.PriorityQueue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.offer(100);
        pq.offer(99);
        pq.offer(85);
        pq.offer(101);
        pq.offer(1000);
        pq.offer(23);
        pq.offer(1);
        pq.offer(98);

        while(!pq.isEmpty())
            System.out.println(pq.poll());

    }
}
