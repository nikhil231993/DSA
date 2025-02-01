package leetcode.heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node1{

    protected int value;
    protected int count;

    public Node1(int value, int count){
        this.value=value;
        this.count=count;
    }
}

public class LC1054Barcodes {

    public static void main(String[] args) {

        int[] barcodes =new int[] {1,1,1,2,2,2};

        int[] result=rearrangeBarcodes(barcodes);
        for(int n:result)
            System.out.println(n);
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {

        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<barcodes.length;i++){
            map.put(barcodes[i], map.getOrDefault(barcodes[i],0)+1);
        }

        PriorityQueue<Node1> pq=new PriorityQueue<>((a,b)->b.count - a.count);
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            pq.offer(new Node1(m.getKey(),m.getValue()));
        }

        int[] result=new int[barcodes.length];
        int i=0;

        while(!pq.isEmpty()){

            Integer num = pq.peek().value;
            Integer c = pq.peek().count;
            pq.poll();

            if(i>0 && num == result[i-1]){
                Integer newNum=pq.peek().value;
                Integer newC=pq.peek().count;
                pq.poll();
                newC--;
                result[i++]=newNum;
                if(newC>0)
                    pq.offer(new Node1(newNum, newC));
                pq.offer(new Node1(num, c));
                continue;
            }
            result[i++]=num;
            c--;
            if(c>0)
                pq.offer(new Node1(num, c));
        }
        return result;
    }
}
