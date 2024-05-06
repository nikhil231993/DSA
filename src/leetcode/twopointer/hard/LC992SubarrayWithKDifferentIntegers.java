package leetcode.twopointer.hard;

import java.util.HashMap;

public class LC992SubarrayWithKDifferentIntegers {

    public static void main(String[] args) {

       int[] nums =new int[] {1,2,1,3,4};
       int k = 3;
       System.out.println(subarraysWithKDistinct(nums,k));
       //All other approaches are mentioned in striver package of two pointer
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {

        int atLeastK=func(nums, k);
        int lessThanK=func(nums, k-1);
        return atLeastK-lessThanK;
    }

    public static int func(int[] nums, int k){

        HashMap<Integer, Integer> map=new HashMap();
        int right=0, left=0, n=nums.length;
        int count=0;
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                left++;
            }

            if(map.size()<=k){
                count+=right-left+1;
            }
            right++;
        }
        return count;
    }
}
