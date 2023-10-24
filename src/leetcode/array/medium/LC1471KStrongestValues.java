package leetcode.array.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node1{
    int key;
    int diff;
    public Node1(int key, int diff){
        this.key=key;
        this.diff=diff;
    }
}
public class LC1471KStrongestValues {

    public static void main(String[] args) {
        int[] arr =new int[] {1,2,3,4,5};
        int k = 2;
        int[] result=getStrongest(arr,k);
        for(int n:result)
            System.out.println(n);
    }

    public static int[] getStrongest(int[] arr, int k) {

        PriorityQueue<Node1> pq=new PriorityQueue<>((a, b)->a.diff==b.diff?a.key-b.key:a.diff-b.diff);

        Arrays.sort(arr);
        int n=arr.length;
        int median=0;
        median=arr[(n-1)/2];
        for(int num:arr){
            pq.offer(new Node1(num, Math.abs(num-median)));
            if(pq.size()>k)
                pq.poll();
        }
        int[] r=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            r[i++]=pq.poll().key;
        }
        return r;
    }
}
