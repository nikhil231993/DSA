package leetcode.twopointer.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC2799CountCompleteSubarrays {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,1,2,3};

        HashSet<Integer> set=new HashSet();
        for(int i=0; i<nums.length ;i++){
            set.add(nums[i]);
        }

        //Approach 1: Brute Generate all the subarrays
        System.out.println(brute(nums, set.size()));

        //Approach 2: Better
        System.out.println(better(nums, set.size()));

        //we cannot use "if" instead of "while" as in counting we will miss some subarrays. Take an example and try out
        //When we want to find longest length we can use 'if' as its to find max length

        //Approach 4: Using array instead of map
        System.out.println(countCompleteSubarrays(nums));
    }

    private static int better(int[] nums, int k) {

        int atMostEqualToK = subarray(nums, k);
        int atMostEqualToLessThanK = subarray(nums, k-1);
        return atMostEqualToK - atMostEqualToLessThanK;

        // TC:O(2*2n)
        // SC:O(n) if all are distinct
    }

    private static int subarray(int[] nums, int k) {

        int right=0, left=0, n=nums.length, count=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        while(right<n){

            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){

                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            if(map.size() <= k){
                count+=right-left+1;
            }
            right++;
        }
        return count;
    }

    private static int brute(int[] nums, int k) {

        int count=0, n=nums.length;

        for(int i=0; i<n; i++){
            HashSet<Integer> set=new HashSet<>();

            for(int j=i; j<n; j++){
                set.add(nums[j]);
                if(set.size()==k){
                    count++;
                }else if(set.size()>k)
                    break;
            }
        }
        return count;

        //TC:O(n square) * set TC
        //SC:O(n) in case all the digits are different
    }

    private static int countCompleteSubarrays(int[] nums) {

        int n=nums.length;
        Set<Integer> set=new HashSet();
        for(int i=0;i<n;i++)
            set.add(nums[i]);

        int k=set.size();

        return count(n, k, nums)-count(n, k-1, nums);
    }

    private static int count(int n, int k, int[] nums){

        int left=0, right=0, count=0, distinct=0;
        int[] result=new int[2001];
        while(right<n){
            if(result[nums[right]]==0){
                distinct++;
            }
            result[nums[right]]++;
            while(distinct>k){
                result[nums[left]]--;
                if(result[nums[left]]==0)
                    distinct--;
                left++;
            }
            if(distinct<=k)
                count+=right-left+1;
            right++;
        }
        return count;
    }
}
