package leetcode.heap.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Node2 {

    protected Integer key;
    protected Integer freq;

    public Node2(Integer key, Integer freq){
        this.key=key;
        this.freq=freq;
    }
}

public class LC2404MostFrequentEvenElement {


    public static void main(String[] args) {

        int[] nums =new int[] {0,1,2,2,4,4,1};
        
        //Approach 1
        System.out.println(mostFrequentEven(nums));
        
        //Approach 2:
        System.out.println(mostFrequentEvenOptimised(nums));
        
        //Approach 3:
        System.out.println(mostFrequentEvenUsingHeap(nums));
    }

    private static int mostFrequentEvenUsingHeap(int[] nums) {

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int n: nums){
            if(n%2==0)
                map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Node2> pq=new PriorityQueue<>((a, b)-> a.freq==b.freq?b.key-a.key:a.freq-b.freq);
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            pq.offer(new Node2(m.getKey(), m.getValue()));
            if(pq.size()>1)
                pq.poll();
        }
        if(pq.size()==0)
            return -1;
        return pq.peek().key;
    }

    public static int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> map=new HashMap();
        for(Integer num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int count=-1;
        int element=Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){

            Integer c=m.getKey();
            Integer val=m.getValue();
            if(val==count && c%2==0 && c<element){
                count=val;
                element=c;
            } else if (val>count && c%2==0) {
                count=val;
                element=c;
            }
        }
        return element==Integer.MAX_VALUE?-1:element;

        //TC:O(n)
        //SC:O(n) in worst case where each element is unique
    }

    public static int mostFrequentEvenOptimised(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count=-1;
        int element=Integer.MAX_VALUE;

        for (int num : nums) {
            if (num%2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                int newCount = map.get(num);
                if (newCount > count || (newCount == count && num < element)) {
                    count = newCount;
                    element = num;
                }
            }
        }
        return element == Integer.MAX_VALUE ? -1 : element;
    }
}
