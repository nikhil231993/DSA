package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP44LargestDivisibleSubset {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,3};
        int n=nums.length;
        Arrays.sort(nums);//Mandatory step

        System.out.println(divisibleSubset(nums,n));
    }

    private static List<Integer> divisibleSubset(int[] nums, int n) {

        int[] hash=new int[n];
        for(int i=0;i<n;i++)
            hash[i]=i;

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int max=1;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                index=i;
                max=dp[i];
            }
        }

        List<Integer> result=new ArrayList<>();
        int variableIndex=index;
        while(variableIndex!=hash[variableIndex]){
            result.add(nums[variableIndex]);
            variableIndex=hash[variableIndex];
        }
        result.add(nums[variableIndex]);
        Collections.reverse(result);
        return result;

        //TC:O(nlogn) for sorting + O(n square) + O(n)tracking back
        //SC:O(N)
    }
}
