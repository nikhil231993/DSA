package src.leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LC2461MaximumSumDistinctK {

    public static void main(String[] args) {

       int[]  nums = new int[] {1,5,4,2,9,9,9};
       int k = 3;

        //Approach 1: Two for loops

        //Approach 2: Map with while loop

        //Approach 3: Map with if
        System.out.println(maximumSubarraySum(nums, k));

        //Approach 4: Remove map  log n time complexity
        System.out.println(maximumSubarraySumOptimized(nums, k));
    }

    private static long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length, left=0, right=0;
        long sum=0l;
        long max=0l;
        Map<Integer, Integer> map=new HashMap();
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            sum+=nums[right];
            while(right-left+1>k){
                map.put(nums[left], map.get(nums[left])-1);
                sum-=nums[left];
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }
            if(right-left+1==k && map.size()==k){
                max=Math.max(max, sum);
            }
            right++;
        }
        return max;
    }

    private static long maximumSubarraySumOptimized(int[] nums, int k) {
        int n=nums.length, left=0, right=0, count=0;
        long sum=0l;
        long max=0l;
        int[] freq=new int[100001];
        while(right<n){
            if(freq[nums[right]]==0)
                count++;

            freq[nums[right]]++;
            sum+=nums[right];
            while(right-left+1>k){
                freq[nums[left]]--;
                sum-=nums[left];
                if(freq[nums[left]]==0)
                    count--;
                left++;
            }
            if(right-left+1==k && count==k)
                max=Math.max(max, sum);
            right++;
        }
        return max;
    }
}
