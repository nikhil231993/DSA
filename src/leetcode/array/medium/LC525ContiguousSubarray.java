package leetcode.array.medium;

import java.util.HashMap;

public class LC525ContiguousSubarray {

    public static void main(String[] args) {

        //This question is similar to https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

        int[] nums = new int[]{ 0, 1, 0};

        //Approach 1:Optimal Similar to LC560
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {

        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==0)
                nums[i]=-1;
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        int sum=0, max=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            if(sum==0)
                max=Math.max(max, i+1);

            if(map.containsKey(sum)){
                max=Math.max(max, i-map.get(sum));
            }

            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}
