package leetcode.heap.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class SubNode{

    protected int val;
    protected int arrPos;
    protected int valPosInArr;

    public SubNode(int val, int arrPos, int valPosInArr){
        this.val=val;
        this.arrPos=arrPos;
        this.valPosInArr=valPosInArr;
    }
}

public class GfgMergeKSortedArray {

    public static void main(String[] args) {

        int k=4;
        int[][] arr=new int[][]{{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};

        //Approach 1: Brute
        System.out.println(mergeBruteForce(arr,k));

        //Approach 2: Better
        System.out.println(mergeUsingMinHeap(arr, k));

        //Approach 3: Optimal
        System.out.println(mergeKArrays(arr,k));
    }

    private static ArrayList<Integer> mergeUsingMinHeap(int[][] arr, int k) {

       PriorityQueue<Integer> pq=new PriorityQueue<>();
       ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                pq.offer(arr[i][j]);
            }
        }

        while(!pq.isEmpty())
            list.add(pq.poll());
        return list;

        //TC:O(n*m + n*m log n*m)
        //SC:O(n*m) * 2
    }

    private static ArrayList<Integer> mergeBruteForce(int[][] arr, int k) {

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
        return list;

        //TC:O(n*m log n*m)
        //SC:O(n*m)
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {

        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<SubNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<k;i++){
            SubNode node=new SubNode(arr[i][0], i, 0);
            pq.offer(node);
        }//TC:O(k)

        while(!pq.isEmpty()){

            SubNode temp=pq.poll();
            result.add(temp.val);
            int arrPos= temp.arrPos;
            int valPosInArr=temp.valPosInArr;

            if(valPosInArr+1 < arr[arrPos].length){
                SubNode inertVal=new SubNode(arr[arrPos][valPosInArr+1], arrPos, valPosInArr+1);
                pq.offer(inertVal);
            }
        }
        return result;
    }

    //TC:O(k square log k)
    //SC:k square as at any moment heap has only k elements at the max
}
