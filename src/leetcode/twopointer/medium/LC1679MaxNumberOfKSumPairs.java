package leetcode.twopointer.medium;

import java.util.Arrays;
import java.util.HashMap;

public class LC1679MaxNumberOfKSumPairs {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,3,4};
        int k = 5;

        //Approach 1:
        System.out.println(maxOperations(nums,k));

        //Approach 2: Best same as two sum
        System.out.println(maxOperationsUsingMap(nums, k));
    }

    public static int maxOperationsUsingMap(int[] nums, int k) {

        int n=nums.length, count=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<n; i++){
            if(map.containsKey(k-nums[i])){
                count++;
                if(map.get(k-nums[i])==1)
                    map.remove(k-nums[i]);
                else
                    map.put(k-nums[i], map.get(k-nums[i])-1);
            }else{
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        return count;

        //TC:O(n)
        //SC:O(n)
    }

    public static int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int count=0;
        while(left<right){
            if(nums[left]+nums[right]>k)
                right--;
            else if(nums[left]+nums[right]<k)
                left++;
            else{
                count++;
                left++;
                right--;
            }
        }
        return count;

        //TC:O(n log n)
        //SC:O(1)
    }
}
