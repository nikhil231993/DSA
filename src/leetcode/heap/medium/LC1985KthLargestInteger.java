package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC1985KthLargestInteger {

    public static void main(String[] args) {

        String[] nums =new String[] {"3","6","7","10"};
        int k = 4;
        System.out.println(kthLargestNumber(nums,k));
    }

    public static String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        for(String n: nums){
            pq.offer(n);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();

        //TC:O(n log k)
        //SC:O(k)
    }
}
