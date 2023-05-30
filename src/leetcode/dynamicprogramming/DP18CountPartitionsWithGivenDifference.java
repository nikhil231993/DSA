package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP18CountPartitionsWithGivenDifference {
    //In this question we have numbers greater than or equal to 0

    public static void main(String[] args) {
        int[] arr =new int[] {0,0,1};
        int d=1;
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

        //Tabulation
        int[][] dp1=new int[n][(totalSum-d)/2+1];
        for(int[] r:dp1)
            Arrays.fill(r,-1);
        System.out.println(tabulation(n,(totalSum-d)/2,arr,dp1));

        System.out.println(space(n,(totalSum-d)/2,arr));
    }

    private static int space(int n, int K, int[] arr) {
        int[] prev=new int[K+1];
        int[] curr=new int[K+1];
        if(arr[0]==0)
            prev[0]=2;
        else prev[0]=1;

        if(arr[0]<=K && arr[0]!=0)
            prev[arr[0]]=1;

        for(int i=1;i<n;i++){
            //Below we start from 0  because we removed sum of zero from base case
            for(int target=0;target<=K;target++){
                int np=prev[target];
                int p=0;
                if(arr[i]<=target)
                    p=prev[target-arr[i]];
                curr[target]=p+np;
            }
            prev=curr;
        }
        return prev[K];
    }

    private static int tabulation(int n, int K, int[] arr, int[][] dp1) {

       //Adding same as memoization condition
        if(arr[0]==0)
            dp1[0][0]=2;
        else
            dp1[0][0]=1;
        //Above is first base case

        if(arr[0]!=0 && arr[0]<=K)
            dp1[0][arr[0]]=1;
        //Above is second base case

        for(int i=1;i<n;i++){
            //Below we start from 0  because we removed sum of zero from base case
            for(int target=0;target<=K;target++){
                int np=dp1[i-1][target];
                int p=0;
                if(arr[i]<=target)
                    p=dp1[i-1][target-arr[i]];
                dp1[i][target]=p+np;
            }
        }
        return dp1[n-1][K];
    }

    private static int memoization(int i, int sum, int[] arr, int[][] dp) {

        if(i==0)
        {
            if(sum==0 && arr[i]==0)
                return 2;
            if(sum==0 || arr[i]==sum) return 1;
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

        if(i==0)
        {
            if(sum==0 && arr[i]==0)
                return 2;
            if(sum==0 || arr[i]==sum) return 1;
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
