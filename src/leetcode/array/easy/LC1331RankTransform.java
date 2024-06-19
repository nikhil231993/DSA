package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


class NodeRank{

    protected int element;
    protected int pos;

    public NodeRank(int element, int pos){
        this.element=element;
        this.pos=pos;
    }
}

public class LC1331RankTransform {

    public static void main(String[] args) {

        int[] arr =new int[] {40,10,20,30};

        //Approach 1
        int[] r1=arrayRankTransform(arr);
        for(int n:r1)
            System.out.println(n);

        System.out.println("###############");

        //Approach 2
        int[] arr1 =new int[] {40,10,20,30};
        int[] r2=arrayRankTransformUsingHeap(arr1);
        for(int n:r2)
            System.out.println(n);
    }

    public static int[] arrayRankTransform(int[] arr) {

        int n=arr.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        int rank=1;

        int[] ans=new int[n];
        for(int i=0; i<n; i++){
            ans[i]=arr[i];
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], rank++);
            }
        }

        for(int i=0; i<n; i++){
            ans[i]=map.get(ans[i]);
        }
        return ans;
    }

    public static int[] arrayRankTransformUsingHeap(int[] arr) {

        PriorityQueue<NodeRank> pq=new PriorityQueue<>((a, b)->a.element-b.element);
        for(int i=0;i<arr.length;i++){
            pq.offer(new NodeRank(arr[i],i));
        }

        int rank=1;
        int[] rankArray=new int[arr.length];
        int previous=-1;
        int previousRank=-1;
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
