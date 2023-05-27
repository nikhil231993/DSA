package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP14SubsetEqualsTarget {

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,13,13};
        int n= arr.length;
        int target=4;

        //Recursion
        System.out.println(recursion(n-1,target,arr));

        //Memoization
        //Assuming constraints are 10 raise to 3
        int[][] dp=new int[10^3+1][10^+1];
        int index=dp.length;
        for(int[] row:dp)
            Arrays.fill(row,-1);
        System.out.println(memoization(n-1,target,arr,dp));
    }

    private static boolean memoization(int n, int target, int[] arr, int[][] dp) {

        if(target==0)
            return true;
        if(n==0)
            return arr[n]==target;

        if(dp[n][target]!=-1)
            return dp[n][target]==0?false:true;

        boolean notpick=memoization(n-1,target,arr,dp);
        boolean pick=false;
        if(arr[n]<=target)
            pick=memoization(n-1,target-arr[n],arr,dp);
        dp[n][target]=notpick|| pick?1:0;
        return notpick || pick;
        //TC:O(N*target)
        //SC:o(N*target) dp array+O(N) stack
    }

    private static boolean recursion(int n, int target, int[] arr) {

        if(target==0)
            return true;
        if(n==0)
            return target==arr[0];

        boolean notpick=recursion(n-1,target,arr);
        boolean pick=false;
        if(arr[n]<=target)
                pick=recursion(n-1,target-arr[n],arr);
        return notpick || pick;
        //TC:O(2 raise to N)
        //SC:O(N) auxiliary stack

    }
}
