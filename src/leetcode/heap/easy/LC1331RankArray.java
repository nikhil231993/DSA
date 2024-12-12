package leetcode.heap.easy;

import java.util.PriorityQueue;

class NodeRank{

    protected int element;
    protected int pos;

    public NodeRank(int element, int pos){
        this.element=element;
        this.pos=pos;
    }
}

public class LC1331RankArray {

    public static void main(String[] args) {
       int[] arr =new int[] {20, 15, 26, 2, 98, 6};
       int[] r=arrayRankTransform(arr);
       for(int num:r)
           System.out.println(num);
    }

    public static int[] arrayRankTransform(int[] arr) {

        PriorityQueue<NodeRank> pq=new PriorityQueue<>((a, b)->a.element-b.element);
        for(int i=0;i<arr.length;i++){
            pq.offer(new NodeRank(arr[i],i));
        }

        int rank=1;
        int[] rankArray=new int[arr.length];
        int previous=Integer.MIN_VALUE, previousRank=Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            int v=pq.peek().element;
            int p=pq.peek().pos;
            pq.poll();
            if(previous==v){
                rankArray[p]=previousRank;
                continue;
            }
            rankArray[p]=rank;
            previous=v;
            previousRank=rank;
            rank++;
        }
        return rankArray;
    }
}
