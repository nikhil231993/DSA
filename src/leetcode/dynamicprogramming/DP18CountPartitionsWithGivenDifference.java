package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP18CountPartitionsWithGivenDifference {

    public static void main(String[] args) {
        int[] arr =new int[] {5,2,6,4};
        int d=3;
        int n=arr.length;

        int totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=arr[i];

        if(totalSum-d <0 || ((totalSum-d)%2)!=0)
            System.out.println("cannot be done");

        //s1-s2=d
        //totalsum=s1+s2;
        //totalsum-s2-s2=d
        //s2=(totalsum-d)/2

        //edge case
        //totalsum-d cannot go less than as all numbers are positive
        //if (totalsum-d)/2 is odd then we cannot find as numbers in array are not decimal

        System.out.println(recursion(n-1,(totalSum-d)/2,arr));

        int[][] dp=new int[n][(totalSum-d)/2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);

        System.out.println(memoization(n-1,(totalSum-d)/2,arr,dp));
    }

    private static int memoization(int i, int sum, int[] arr, int[][] dp) {

        if(sum==0) return 1;
        if(i==0)
        {
            if(sum==arr[i])
                return 1;
            return 0;
        }

        if(dp[i][sum]!=-1)
            return dp[i][sum];
        int np=memoization(i-1,sum,arr,dp);
        int p=0;
        if(arr[i]<=sum)
            p=memoization(i-1,sum-arr[i],arr,dp);

        return dp[i][sum]=p+np;
    }

    private static int recursion(int i, int sum, int[] arr) {

        if(sum==0) return 1;
        if(i==0)
        {
            if(sum==arr[i])
                return 1;
            return 0;
        }
        int np=recursion(i-1,sum,arr);
        int p=0;
        if(arr[i]<=sum)
            p=recursion(i-1,sum-arr[i],arr);

        return p+np;

        //Tc:O(2 raise to N)
        //SC:O(N) recursion
    }
}
