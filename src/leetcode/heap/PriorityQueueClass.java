package leetcode.heap;

import java.util.PriorityQueue;

class Node{
     int value;
     int key;
    public Node(int value, int key){
        this.value=value;
        this.key=key;
    }
}

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

        PriorityQueue<Node> pq1=new PriorityQueue<>((a,b)->b.value-a.value);
        int x=3;
        int k=4;

        int[] arr=new int[]{1,2,3,4,5};

        for(Integer n: arr)
            pq1.offer(new Node(Math.abs(x-n),n));

        System.out.println("Difference: ");
//        while (!pq1.isEmpty()){
//            Node n=pq1.poll();
//            System.out.println(n.key+ "------"+n.value);
//        }

        Node n=pq1.poll();

        System.out.println(n.value+"---"+n.key);
    }
}
