package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP17CountSubsetsWithSumKWithZero {

    //Two Solutions for number having 0
    //Solution 1:
    //if numbers range from 0 to n instead of 1 to n then find 2 raise to n
    // where n is the no of zeroes an multiply the result we have solved it in next
    //Solution 2:
    // we add conditions which is done in next DP17

    public static void main(String[] args) {

        int[] nums=new int[]{2,0,4};
        int n=nums.length;
        int sum=6;

        //Recursion
        System.out.println(recursion(nums,n-1,sum));

        //Memoization
        int[][] dp=new int[n][sum+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(nums,n-1,sum,dp));

        //tabulation
        int[][] dp1=new int[n][sum+1];
        System.out.println(tabulation(nums, n, sum, dp1));

        //space
        System.out.println(space(nums, n, sum));
    }

    public static int space(int[] num, int n, int k) {

        int[] prev=new int[k+1];
        if(num[0]==0)
            prev[0]=2;
        else
            prev[0]=1;

        if(num[0]!=0 && num[0]<=k)
            prev[num[0]]=1;

        // Fill the DP array for subsequent rows
        for (int ind = 1; ind < n; ind++) {
            int[] curr=new int[k+1];
            curr[0]=1;
            for (int target = 0; target <= k; target++) {
                // Not taking the current element
                int notTaken = prev[target];

                // Taking the current element (if possible)
                int taken = 0;
                if (num[ind] <= target) {
                    taken = prev[target - num[ind]];
                }

                // Update the DP array
                curr[target] = (notTaken + taken) % (int)(1e9 + 7);
            }
            prev=curr;
        }

        // The result is stored in the last cell of the DP array
        return prev[k];
    }

    public static int tabulation(int[] num, int n, int k, int[][] dp) {

        if(num[0]==0)
            dp[0][0]=2; //I am at index =0, sum=0 and num[0]=0
        else
            dp[0][0]=1; //I am at index =0, sum=0 and num[0]!=0 then only one case that is not take
        if(num[0]!=0 && num[0]<=k)
            dp[0][num[0]]=1;

        // Fill the DP array for subsequent rows
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                // Not taking the current element
                int notTaken = dp[ind - 1][target];

                // Taking the current element (if possible)
                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                // Update the DP array
                dp[ind][target] = (notTaken + taken) % (int)(1e9 + 7);
            }
        }

        // The result is stored in the last cell of the DP array
        return dp[n - 1][k];
    }

    private static int memoization(int[] nums, int i, int sum, int[][] dp) {

        if(i==0){
            if(sum==0 && nums[i]==0) return 2;
            if(sum==0 || nums[i]==sum)
                return 1;
            return 0;
        }

        if(dp[i][sum]!=-1)
            return dp[i][sum];

        int np=memoization(nums,i-1,sum,dp);
        int p=0;
        if(nums[i]<=sum)
            p=memoization(nums,i-1,sum-nums[i],dp);
        return dp[i][sum]=((np+p)%(int)(1e9+7)); //modulo as question is asking for it

        //TC:O(N*Sum)
        //SC:O(N*sum) dp array +O(N)stack
    }

    private static int recursion(int[] nums, int i,int sum) {

        if(i==0){
            if(sum==0 && nums[i]==0) return 2;
            if(sum==0 || nums[i]==sum)
                return 1;
            return 0;
        }

        int np=recursion(nums,i-1,sum);
        int p=0;
        if(nums[i]<=sum)
            p=recursion(nums,i-1,sum-nums[i]);

        return np+p;

        //TC:O(2 raise to n)
        //SC:O(n) recursion stack
    }
}
