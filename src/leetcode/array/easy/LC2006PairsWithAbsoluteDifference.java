package leetcode.array.easy;

import java.util.HashMap;

public class LC2006PairsWithAbsoluteDifference {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,2,1};
        int k = 1;
        System.out.println(countKDifference(nums,k));
    }

    public static int countKDifference(int[] nums, int k) {

        int count=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k))
                count+=map.get(nums[i]-k);
            if(map.containsKey(k+nums[i])) // we cannot use else if because if array has 4,5,3
                // then it won't work with else, Try this [9,3,1,1,4,5,4,9,5,10]..correct output is 8 but with else if we get 7
                count+=map.get(k+nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count;

        //TC:O(n)
        //SC:O(1)
        }
    }
