package leetcode.graph;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.add(10);
        pq.add(2);
        pq.add(100);

        pq.poll();
        for(Integer n:pq)
            System.out.println(n);
    }
}
