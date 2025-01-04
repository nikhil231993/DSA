package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP41LC300LongestIncreasingSubsequence {

    public static void main(String[] args) {

        //f(3,0) Length of LIS starting from 3rd index , whose previousIndex is 0

        int[] nums =new int[] {10,9,2,5,3,7,101,18};
        nums=new int[]{5,4,11,1,16,8};
        int n=nums.length;

        //Recursion
        System.out.println(recursion(n,nums,0,-1));

        //For Memoization we do a right shift for prevIndex as the prevIndex is -1 initially and we cannot
        //have such a case in dp
        //Memoization
        int[][] dp=new int[n][n+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n, nums, 0,-1, dp));

        //Tabulation
        int[][] dp1=new int[n+1][n+1];
        System.out.println(tabulation(n,nums,0,-1,dp1));

        //Space
        System.out.println(space(n,nums,0,-1,dp1));

        //Different way of doing above to do it in 1 array dp
        System.out.println(iterativeSpaceOpitmized(n,nums));
    }

    private static int iterativeSpaceOpitmized(int n, int[] nums) {

        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

        //TC:O(N square)
        //SC:O(N)
        //Above solution is used to trace back the LIS
    }

    private static int space(int n, int[] nums, int index, int prevIndex, int[][] dp1) {

        int[] ahead=new int[n+1];
        //Above we don't have to write as we have already set everything to 0

        for(int ind=n-1;ind>=0;ind--){
            int[] curr=new int[n+1];
            for(int prevI=ind-1;prevI>=-1;prevI--){
                int np=0+ahead[prevI+1];
                //For second param in dp will have coordinate shift
                int p=0;
                if(prevI==-1 || nums[ind]>nums[prevI])
                    p=1+ahead[ind+1];
                //For second param in dp will have coordinate shift
               curr[prevI+1]=Math.max(np,p);
            }
            ahead=curr;
        }
        return ahead[prevIndex+1];

        //TC:O(N*N)
        //SC:O(N*N) dp array
    }

    private static int tabulation(int n, int[] nums, int index, int prevIndex, int[][] dp1) {

        for(int j=0;j<=n;j++)
            dp1[n][j]=0;
        //Above we don't have to write as we have already set everything to 0

        for(int ind=n-1;ind>=0;ind--){
            for(int prevI=ind-1;prevI>=-1;prevI--){ //prevI should be before ind

                int np=0+dp1[ind+1][prevI+1];
                //For second param in dp will have coordinate shift

                int p=0;
                if(prevI==-1 || nums[ind]>nums[prevI])
                    p=1+dp1[ind+1][ind+1];
                //For second param in dp will have coordinate shift

                dp1[ind][prevI+1]=Math.max(np,p);
            }
        }
        return dp1[index][prevIndex+1];

        //TC:O(N*N)
        //SC:O(N*N) dp array
    }

    private static int memoization(int n, int[] nums, int index, int prevIndex, int[][] dp) {

        if(index==n)
            return 0;

        if(dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];

        int np=0+memoization(n,nums,index+1,prevIndex,dp);
        int p=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex])
            p=1+memoization(n,nums,index+1, index,dp);
        return dp[index][prevIndex+1]=Math.max(np,p);

        //TC:O(N*N)
        //SC:O(N) recursion +O(N*N)
    }

    private static int recursion(int n, int[] nums, int index, int prevIndex) {

        if(index==n)
            return 0;

        int np=0+recursion(n,nums,index+1,prevIndex);//not pick so prevIndex remains same
        int p=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex])
            p=1+recursion(n,nums,index+1,index);    //pick so prevIndex becomes current index
        return Math.max(np,p);

        //TC:O(2 raise to N)
        //SC:O(N)
    }
}
