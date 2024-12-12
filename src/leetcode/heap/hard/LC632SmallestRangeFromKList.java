package leetcode.heap.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class LC632SmallestRangeFromKList {

    public static void main(String[] args) {

        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> a1 = Arrays.asList(4, 10, 15,24,26);
        List<Integer> a2 = Arrays.asList(0,9, 12, 20);
        List<Integer> a3 = Arrays.asList(5, 18, 22,30);
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);

        //Approach 3
        int[] res=smallestRange(arr);

        for(int n:res)
            System.out.println(n);
    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        int k=nums.size();

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        PriorityQueue<NodeValue> pq=new PriorityQueue<>((a, b)->a.value-b.value);

        for(int i=0;i<k;i++){
            NodeValue node=new NodeValue(nums.get(i).get(0),0,i);
            min=Math.min(min,nums.get(i).get(0));
            max=Math.max(max,nums.get(i).get(0));
            pq.offer(node);
        }

        int start=min;
        int end=max;

        while(!pq.isEmpty()){
            NodeValue temp=pq.poll();
            min=temp.value;

            if(max-min<end-start){
                start=min;;
                end=max;
            }
            if(temp.valueColInArr+1<nums.get(temp.valueRowInArr).size()){
                NodeValue in=new NodeValue(nums.get(temp.valueRowInArr).get(temp.valueColInArr+1),temp.valueColInArr+1,temp.valueRowInArr);
                max=Math.max(max,in.value);
                pq.offer(in);
            }else{
                break;
            }
        }
        return new int[]{start,end};

        //TC:O(n*klog k)
        //SC:O(log k)
    }
}
