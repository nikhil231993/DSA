package leetcode.company.microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239SlidingWIndowMaximum {

    public static void main(String[] args) {
       int[] nums =new int[] {1,3,-1,-3,5,3,6,7};
       int k = 3;
       int[] result=maxSlidingWindow(nums, k);
       for(int num:result)
           System.out.println(num);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>(); // we use new LinkedList<>() also here
        int[] result=new int[n-k+1];
        int j=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k)
                dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1){
                result[j++]=nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
