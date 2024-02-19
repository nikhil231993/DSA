package leetcode.heap.easy;

import java.util.PriorityQueue;

class Node1{

    int key;
    int value;
    public Node1(int key, int value){
        this.key=key;
        this.value=value;
    }
}

public class LC506Rankings {

    public static void main(String[] args) {

        int[] score =new int[] {5,4,3,2,1};

        String[] result=findRelativeRanks(score);
        for(String s: result)
            System.out.println(s);
    }

    public static String[] findRelativeRanks(int[] score) {

        int n=score.length;
        PriorityQueue<Node1> pq=new PriorityQueue<>((a, b)->b.key-a.key);
        int i=0;
        for(int n1:score)
            pq.offer(new Node1(n1,i++));

        String[] str=new String[score.length];
        if(n>=1){
            int index=pq.peek().value;
            str[index]="Gold Medal";
            pq.poll();
        }
        if(n>=2){
            int index1=pq.peek().value;
            str[index1]="Silver Medal";
            pq.poll();
        }
        if(n>=3){
            int index2=pq.peek().value;
            str[index2]="Bronze Medal";
            pq.poll();
        }
        if(n>=4){
            int k=4;
            while(!pq.isEmpty()){
                int n1=pq.peek().value;
                pq.poll();
                str[n1]=String.valueOf(k++);
            }
        }
        return str;
    }
}
