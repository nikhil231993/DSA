package leetcode.heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node{

    protected int value;

    protected int key;

    public Node(int value, int key){
        this.value=value;
        this.key=key;
    }
}

public class LC347TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums=new int[]{1,1,1,2,2,3};
        int k=2;

        //Quick Select is best solution .Learn if time permits

        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Node> pq=new PriorityQueue<Node>((a,b)->a.value-b.value);

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//O(N)
            Node n=new Node(entry.getValue(), entry.getKey());
            pq.offer(n); //log k
            if(pq.size()>k)
                pq.poll(); //log k
        }

        while(!pq.isEmpty())
            System.out.println(pq.poll().key);

        //TC:O(NlogK)
        //SC:O(N) for map and O(K) for priority queue
    }

    private int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int no:nums)
            map.put(no, map.getOrDefault(no, 0)+1);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        int[] ans=new int[k];
        int i=0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            pq.offer(m.getKey());
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            ans[i++]=pq.poll();
        return ans;
    }
}
