package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP14SubsetEqualsTarget { //7:59

    public static void main(String[] args) {

        int[] arr=new int[]{2,5,1,6,7};
        int n= arr.length;
        int target=4;

        //Recursion
        System.out.println(recursion(n-1,target,arr));

        //Memoization
        //Assuming constraints are 10 raise to 3
        int[][] dp=new int[n][target+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        System.out.println(memoization(n-1,target,arr,dp));

        //Tabulation (for tabulation we can take dp with true or false)
        boolean[][] dp1=new boolean[n][target+1];
        System.out.println(tabulation(n,target,dp1,arr));

        //Space optimization
        System.out.println(space(n,target,arr));
    }

    private static boolean space(int n, int k, int[] arr) {

        boolean[] prev=new boolean[k+1];

        prev[0]=true;
        if(arr[0]<=k)
            prev[arr[0]]=true;

        for(int i=1;i<n;i++){

            boolean[] curr=new boolean[k+1];
            curr[0]=true;
            for(int target=1;target<=k;target++){

                boolean notpick=prev[target];
                boolean pick=false;
                if(arr[i]<=target)
                    pick=prev[target-arr[i]];
                curr[target]=notpick|| pick;
            }
            prev=curr;
        }
        return prev[k];
    }

    private static boolean tabulation(int n, int k, boolean[][] dp,int[] arr) {

        for(int i=0;i<n;i++)
            dp[i][0]=true;

        if(arr[0]<=k)
            dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean notpick=dp[i-1][target];
                boolean pick=false;
                if(arr[i]<=target)
                    pick=dp[i-1][target-arr[i]];
                dp[i][target]=notpick|| pick;
            }
        }
        return dp[n-1][k];

        //TC:O(N*target)
        //SC:O(N*target) dp array
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

        dp[n][target]=notpick || pick?1:0;
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
