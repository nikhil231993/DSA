package leetcode.heap.codehelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class NodeValue{

    protected int value;
    protected int valueColInArr;
    protected int  valueRowInArr;

    public NodeValue(int value, int valueColInArr, int valueRowInArr){

        this.value=value;
        this.valueColInArr=valueColInArr;
        this.valueRowInArr=valueRowInArr;
    }
}

public class L76MergeKSortedArray {

    public static void main(String[] args) {

        int k=4;
        int[][] arr=new int[][]{{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};

        //Approach 1:
        int[] r = mergeKArrays(arr,k);

        for(Integer num:r)
            System.out.println(num);

        //Approach 2:
        int[][] arr1=new int[][]{{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArraysUsingHeap(arr1,k));
    }

    private static ArrayList<Integer> mergeKArraysUsingHeap(int[][] arr, int k) {

        PriorityQueue<NodeValue> pq=new PriorityQueue<>((a,b)->a.value-b.value);
        for(int i=0; i<k; i++){
            pq.offer(new NodeValue(arr[i][0], 0, i));
        }

        ArrayList<Integer> result=new ArrayList<>();
        while(!pq.isEmpty()){
            NodeValue temp=pq.poll();
            result.add(temp.value);
            int valueCol=temp.valueColInArr;
            int valueRow=temp.valueRowInArr;

            if(valueCol+1 < arr[valueRow].length){
                pq.offer(new NodeValue(arr[valueRow][valueCol+1],valueCol+1,valueRow));
            }
        }
        return result;

        //TC:O(k logk)+O(n*k  log k)
        //SC:k as at any moment heap has only k elements at the max + O(n*k) for storing the data
    }

    private static int[] mergeKArrays(int[][] arr, int k) {

        int size=0;
        for(int[] a:arr)
            size+=a.length;
        int[] result=new int[size];

        int i=0;
        for(int[] a: arr){
            for(int num : a){
                result[i++]=num;
            }
        }

        Arrays.sort(result);
        return result;

        // TC:O(n*k log n*k)
        // SC:O(n*k)
    }
}
