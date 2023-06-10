package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP54LC1043PartitionArrayMaximumSum {

    public static void main(String[] args) {
       int[] arr =new int[] {1,15,7,9,2,5,10};
       int k = 3;
        int n= arr.length;
       //Recursion
        System.out.println(recursion(0,arr,k,n));

        //Memoization
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(memoization(0,arr,k,n,dp));


        //Tabulation
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(arr,k,n,dp1));
    }

    private static int tabulation(int[] arr, int k, int n, int[] dp) {

        dp[n]=0;

        for(int i=n-1;i>=0;i--){
            int len=0;
            int max=Integer.MIN_VALUE;
            int maxAns=Integer.MIN_VALUE;
            for(int j=i;j<Math.min(n,i+k);j++){
                len++;
                max=Math.max(max,arr[j]);
                int sum=len*max+dp[j+1];
                maxAns=Math.max(maxAns,sum);
            }
           dp[i]=maxAns;
        }
        //TC:O(N)*k
        //SC:O(N)
        return dp[0];
    }

    private static int memoization(int i, int[] arr, int k, int n, int[] dp) {

        if(i==n)
            return 0;

        if(dp[i]!=-1)
            return dp[i];
        int len=0;
        int max=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+memoization(j+1,arr,k,n,dp);
            maxAns=Math.max(maxAns,sum);
        }
        return dp[i]=maxAns;
        //TC:O(N) changing states *O(K)
        //SC:O(N) dp+ O(N) recursion stack
    }

    private static int recursion(int i, int[] arr, int k,int n) {

        if(i==n)
            return 0;
        int len=0;
        int max=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+recursion(j+1,arr,k,n);
            maxAns=Math.max(maxAns,sum);
        }
        return maxAns;
        //TC:O(exponential)
    }
}
