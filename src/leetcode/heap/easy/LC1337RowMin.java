package leetcode.heap.easy;

import java.util.PriorityQueue;

class Node{

    protected int row;
    protected int count;

    public Node(int row, int count){
        this.row=row;
        this.count=count;
    }
}

public class LC1337RowMin {

    public static void main(String[] args) {

       int[][] mat = new int[][]
               {{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};

       int k = 3;
       int[] result=kWeakestRows(mat,k);

       System.out.println("#########");

       for(Integer r: result)
           System.out.println(r);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Node> pq=new PriorityQueue<>((a, b)->a.count == b.count ? b.row - a.row : b.count - a.count);

        for(int i=0; i<mat.length; i++){

            int no = required(mat[i], 1);
            pq.offer(new Node(i, no));
            if(pq.size()>k)
                pq.poll();
        }

        PriorityQueue<Node> pq1=new PriorityQueue<>((a,b)->a.count == b.count ? a.row - b.row : a.count - b.count);
        while(!pq.isEmpty()){
            Integer r = pq.peek().row;
            Integer c = pq.peek().count;
            pq1.offer(new Node(r,c));
            pq.poll();
        }
        int[] arr=new int[pq1.size()];
        int l=0;
        while(!pq1.isEmpty()){
            arr[l++]=pq1.poll().row;
        }
        return arr;
    }

    public static int required(int[] mat, int target){

        int low=0, ans=0;
        int high=mat.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mat[mid]<target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return high+1;
    }
}
