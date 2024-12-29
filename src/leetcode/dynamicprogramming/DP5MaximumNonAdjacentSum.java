package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP5MaximumNonAdjacentSum {

    public static void main(String[] args) {

        int[] nums =new int[] {4,2,4};
        int n=nums.length;

        //recursion
        System.out.println(recursion(nums,n-1));

        //Memoization
        //Step 1 : Create dp array
        //Step 2 : add if condition
        //Step 3: Assign result to dp[n] or dp[n-1];
        int[] dp=new int[n]; //or n+1
        Arrays.fill(dp,-1);
        System.out.println(memoization(nums,dp,n-1));

        //Tabulation
        //Step 1 : Create dp array same as above
        //Step 2 : Change method call to dp
        //Step 3: Assign result to dp[n] or dp[n-1];
        int[] dp1=new int[n]; //or n+1
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(nums,dp1,n)); //or n-1

        //Space optimization
        System.out.println(space(nums,n));
    }

    private static int space(int[] nums, int n) {

       int prev=nums[0];
       int prev2=0;

        for(int i=1;i<n;i++) {
            int pick = nums[i] ;
            if(i>1)
                pick+=prev2;
            int notpick = 0 + prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;

        //TC:O(N)
        //TC:O(1)
    }

    private static int tabulation(int[] nums, int[] dp, int n) {

       dp[0]=nums[0];
       int negIndex=0;//just a placeholder

        for(int i=1; i<n;i++) { //or i<=n
            int pick = nums[i] ;
            if(i>1) //or i>=2
                pick+=dp[i - 2];
            int notpick = 0 + dp[i - 1];

            dp[i]=Math.max(pick, notpick);
        }

        return dp[n-1]; //or dp[n]

        //TC:O(N)
        //TC:O(N) dp array
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

        //TC:O(N)
        //TC:O(N) stack+O(N) dp array
    }

    private static int recursion(int[] nums, int n) {

        if(n==0)//nums[1] is not picked up
            return nums[0];
        if(n<0)
            return 0;

        int pick=nums[n]+recursion(nums,n-2);
        int notpick=0+recursion(nums,n-1);

        return Math.max(pick,notpick);

        //TC:O(2 raise to N close to)
    }
}
