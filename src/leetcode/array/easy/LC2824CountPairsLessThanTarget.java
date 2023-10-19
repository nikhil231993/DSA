package leetcode.array.easy;

import java.util.*;

public class LC2824CountPairsLessThanTarget {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(-6,2,5,-2,-7,-1,3));
        int target=2;
        //Approach 1
        System.out.println(countPairs(list,target));

        //Approach 2 Twopointer
        System.out.println(countPairsPointer(list,target));

    }
    public static int countPairs(List<Integer> nums, int target) {
        int count=0;
        for(int i=0;i<nums.size()-1;i++){
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(i)+nums.get(j)<target)
                    count++;
            }
        }
        return count;
        //TC:O(n*n)
        //sc:O(n
    }

    public static int countPairsPointer(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count=0;
        int left=0;
        int right=nums.size()-1;
        while(left<right){
            if(nums.get(left)+nums.get(right)<target){
                count+=right-left;
                left++;
            }else{
                right--;
            }
        }

        return count;
    }
}
