package leetcode.array.easy;

import java.util.HashMap;

public class LC2006PairsWithAbsoluteDifference {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,2,1};
        int k = 1;

        //This is single parsing and does not have values stored in map due to which we will miss either + or - values.
        System.out.println(countKDifference(nums,k));

        //In this we preload the value in map due to which we have all the combinations and can go with only subtracting
        System.out.println(countKDifferenceOptimized(nums,k));

        System.out.println(countKDifferenceArray(nums, k));
    }

    private static int countKDifferenceArray(int[] nums, int k) {

        int[] arr=new int[201];
        int n=nums.length;
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }

        int ans=0;
        for(int i=k+1; i<201; i++){
            ans+=arr[i]*arr[i-k];
        }
        return ans;
    }

    private static int countKDifferenceOptimized(int[] nums, int k) {

        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]-k)){ // Since we add all the elements already in map it can be either nums[i]-k or nums[i]+k
                count+=map.get(nums[i]-k);
            }
        }
        return count;

        //TC:O(n)
        //SC:O(1)
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
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;

        //TC:O(n)
        //SC:O(1)
        }
    }
