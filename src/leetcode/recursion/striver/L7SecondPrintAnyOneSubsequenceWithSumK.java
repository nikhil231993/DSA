package leetcode.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class L7SecondPrintAnyOneSubsequenceWithSumK {

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,4,5,6,7,8,9};
        int target=9;

        List<List<Integer>> ans=new ArrayList<>();
        subsequenceWithSumK(0, 0, target, nums, ans, new ArrayList<>(), nums.length);

        System.out.println("Subsequences are: " + ans);
    }

    private static boolean subsequenceWithSumK(int i, int sum, int target, int[] nums, List<List<Integer>> ans, List<Integer> list, int n) {

        if(sum>target) return false; // When we add this it passes the TLE test case also
        //above condition can be used only if it has positive numbers
        if(i==n){
            if(sum==target){
                ans.add(new ArrayList<>(list));
                return true;
            }
            return false;
        }

        list.add(nums[i]);
        if(subsequenceWithSumK(i+1, sum+nums[i], target, nums, ans, list, nums.length))
            return true;
        list.remove(list.size()-1);
        if(subsequenceWithSumK(i+1, sum, target, nums, ans, list, nums.length))
            return true;
        return false;
    }
}
