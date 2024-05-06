package leetcode.twopointer.hard;

import java.util.HashMap;
import java.util.HashSet;

public class LC2799CountCompleteSubarrays {

    public static void main(String[] args) {

        int[] nums =new int[] {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {

        HashSet<Integer> set=new HashSet();
        for(int i=0; i<nums.length ;i++){
            set.add(nums[i]);
        }

        int atLeastK=func(nums, set.size());
        int lessThanK=func(nums, set.size()-1);
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
