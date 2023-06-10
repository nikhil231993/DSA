package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP49MCMTabulation {

    public static void main(String[] args) {
        int[] nums=new int[]{10, 20, 30, 40, 50};
        int n=nums.length;

        //Tabulation

        int[][] dp=new int[n][n];//Here we don't need n+1 in size as we are going till n
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(tabulation(nums,n,dp));
    }

    private static int tabulation(int[] nums, int n,int[][] dp) {

        for(int i=1;i<n;i++)
            dp[i][i]=0;

        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int steps=(int)1e9;
                int min=0;
                for(int k=i;k<j;k++){
                    steps=nums[i-1]*nums[k]*nums[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(min,steps);
                }
                dp[i][j]=steps;
            }
        }
        return dp[1][n-1];
        //Time Complexity: O(N*N*N)
        //Reason: There are N*N states and we explicitly run a loop inside the function which will run for N times, therefore at max ‘N*N*N’ new problems will be solved.
        //
        //Space Complexity: O(N*N)
        //
        //Reason: We are using a 2D array ( O(N*N)) space.
    }
}
