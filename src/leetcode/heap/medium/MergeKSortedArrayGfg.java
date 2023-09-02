package leetcode.heap.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

class SubNode{

    int val;
    int arrPos;
    int valPosInArr;

    public SubNode(int val, int arrPos, int valPosInArr){
        this.val=val;
        this.arrPos=arrPos;
        this.valPosInArr=valPosInArr;
    }
}
public class MergeKSortedArrayGfg {
    public static void main(String[] args) {

        int k=3;
        int[][] arr=new int[][]{{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArrays(arr,k));

    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k)
    {
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<SubNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<k;i++){
            SubNode node=new SubNode(arr[i][0],i,0);
            pq.offer(node);
        }//TC:O(k)

        while(!pq.isEmpty()){
            SubNode temp=pq.poll();
            result.add(temp.val);
            int arrPos= temp.arrPos;
            int valPosInArr=temp.valPosInArr;

            if(valPosInArr+1<arr[arrPos].length){
                SubNode inertVal=new SubNode(arr[arrPos][valPosInArr+1],arrPos,valPosInArr+1);
                pq.offer(inertVal);
            }
        }
        return result;
    }

    //TC:klogk
    //SC:k as at any moment heap has only k elements at the max
}
