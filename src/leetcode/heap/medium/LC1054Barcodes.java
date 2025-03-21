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

        System.out.println("**********************");

        int[] result1=rearrangeBarcodesSimplified(barcodes);
        for(int n:result1)
            System.out.println(n);
    }

    private static int[] rearrangeBarcodesSimplified(int[] barcodes) {

        PriorityQueue<Node1> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        HashMap<Integer, Integer> map=new HashMap();
        int n=barcodes.length;
        for(int i=0; i<n;i++){
            map.put(barcodes[i], map.getOrDefault(barcodes[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            pq.offer(new Node1(m.getKey(), m.getValue()));
        }

        int[] arr=new int[n];
        int k=0;
        while(pq.size()>1){
            Node1 n1=pq.poll();
            Node1 n2=pq.poll();
            arr[k++]=n1.value;
            arr[k++]=n2.value;
            n1.count--;
            n2.count--;
            if(n1.count>0)
                pq.offer(new Node1(n1.value, n1.count));
            if(n2.count>0)
                pq.offer(new Node1(n2.value, n2.count));
        }
        if(pq.size()==1)
            arr[k]=pq.poll().value;
        return arr;
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
