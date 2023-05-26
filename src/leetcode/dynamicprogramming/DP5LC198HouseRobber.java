package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP5LC198HouseRobber {

    public static void main(String[] args) {
        int[] nums =new int[] {1,2,3,1};
        int n=nums.length;

        //recursion
        System.out.println(recursion(nums,n-1));
        //TC:2 raise to N close to

        //Memoization
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(nums,dp,n-1));
        //TC:O(N)
        //SC:O(N) stack+O(dp array)

        //Tabulation
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(nums,dp,n-1));
        //TC:O(N)
        //SC:O(dp array)

        //Tabulation
        System.out.println(space(nums,n-1));
        //TC:O(N)
        //SC:O(1)
    }

    private static int space(int[] nums, int n) {
        int prev=nums[0];
        int prev2=0;//palceholder
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1)
                pick+=prev2;
            int notpick=0+prev;

           int curr=Math.max(pick,notpick);
           prev2=prev;
           prev=curr;
        }
        return prev;
    }

    private static int tabulation(int[] nums, int[] dp, int n) {
        dp[0]=nums[0];
        int neg=0;//palceholder
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1)
                pick+=dp[n-2];
            int notpick=0+dp[n-1];

            dp[i]=Math.max(pick,notpick);
        }
        return dp[n];
    }

    private static int memoization(int[] nums, int[] dp, int n) {

        if(n==0)
            return nums[0];
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];

        int pick=nums[n]+memoization(nums,dp,n-2);
        int notpick=0+memoization(nums,dp,n-1);

        return dp[n]=Math.max(pick,notpick);
    }

    private static int recursion(int[] nums, int n) {

        if(n==0)
            return nums[0];
        if(n<0)
            return 0;

        int pick=nums[n]+recursion(nums,n-2);
        int notpick=0+recursion(nums,n-1);
        return Math.max(pick,notpick);
    }
}
