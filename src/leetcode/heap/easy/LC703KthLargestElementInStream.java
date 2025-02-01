package leetcode.heap.easy;


import java.util.PriorityQueue;

class KthLargest {

    private int size=0;

    private PriorityQueue<Integer> pq=new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {

        size=k;
        for(Integer n: nums){
            if(pq.size()<k)
                pq.offer(n);
            else if(pq.size() == k && pq.peek() <= n)
                pq.offer(n);
            if(pq.size()>k)
                pq.poll();
        }
    }

    public int add(int val) {

        if(pq.size()<size)
            pq.offer(val);
        else if(pq.size()==size && pq.peek()<=val)
            pq.offer(val);
        if(pq.size()>size)
            pq.poll();
        return pq.peek();

        //TC:Let M be the size of the initial stream nums given in the constructor, and let N be the number of calls to add
        //O((M+N).log k)
        //SC:O(k)
    }
}

public class LC703KthLargestElementInStream {

    public static void main(String[] args) {

        int[] arr=new int[]{4,5,8,2};

        KthLargest k=new KthLargest(3, arr);

        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}
