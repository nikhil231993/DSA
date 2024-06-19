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
        HashMap<Integer, Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k))
                count+=map.get(nums[i]-k);
            if(map.containsKey(k+nums[i]))
                count+=map.get(k+nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count;

        //TC:O(n)
        //SC:O(1)
        }
    }
