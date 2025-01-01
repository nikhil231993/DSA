package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP21LC494TargetSum {

    public static void main(String[] args) {

        int[] arr =new int[] {1};
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

        //tabulation
        int[][] dp1=new int[n][(totalSum-d)/2+1];
        System.out.println(tabulation(n,(totalSum-d)/2, arr, dp1));

        //space
        System.out.println(space(n,(totalSum-d)/2, arr));
    }

    public static int space(int n, int sum, int[] nums){

        int[] prev=new int[sum+1];
        if(nums[0]==0){
            prev[0]=2;
        }else{
            prev[0]=1;
        }

        if(nums[0]!=0 && nums[0]<=sum)
            prev[nums[0]]=1;

        for(int i=1;i<n;i++){
            int[] curr=new int[sum+1];
            for(int target=0;target<=sum;target++){
                int notpick=prev[target];
                int pick=0;
                if(nums[i]<=target){
                    pick=prev[target-nums[i]];
                }
                curr[target]=notpick+pick;
            }
            prev=curr;
        }
        return prev[sum];
    }

    public static int tabulation(int n, int sum, int[] nums,int[][] dp){

        if(nums[0]==0){
            dp[0][0]=2;
        }else{
            dp[0][0]=1;
        }

        if(nums[0]!=0 && nums[0]<=sum)
            dp[0][nums[0]]=1;

        for(int i=1;i<n;i++){
            for(int target=0;target<=sum;target++){
                int notpick=dp[i-1][target];
                int pick=0;
                if(nums[i]<=target){
                    pick=dp[i-1][target-nums[i]];
                }
                dp[i][target]=notpick+pick;
            }
        }
        return dp[n-1][sum];
    }

    private static int memoization(int i, int sum, int[] arr, int[][] dp) {

        if(i==0) {
            if(sum==0 && arr[i]==0) return 2;
            if(sum==0||sum==arr[i])
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

        if(i==0){
            if(sum==0 && arr[0]==0)
                return 2;
            if(sum==0 || arr[0]==sum)
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
