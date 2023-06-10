package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP53LC132PalidromePartitioning2 {

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int n=str.length();

        //Recursive
        System.out.println(recursion(0,str,n)-1);

        //Memoization
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(0,str,n,dp)-1);

        //Tabulation
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(str,n,dp1)-1);
    }

    private static int tabulation(String str, int n, int[] dp1) {
        dp1[n]=0;

        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,str)){
                    int cost=1+dp1[j+1];
                    min=Math.min(min,cost);
                }
            }
             dp1[i]=min;
        }
        return dp1[0];
        //TC:O(N)
        //SC:o(N)

    }

    private static int memoization(int i, String str, int n,int[] dp) {

        if(i==n)
            return 0;

        if(dp[i]!=-1)
            return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,str)){
                int cost=1+memoization(j+1,str,n,dp);
                min=Math.min(min,cost);
            }
        }
        return dp[i]=min;

        //TC:O(N)*N
        //SC:O(N)+recursion stack
    }

    private static int recursion(int i, String str, int n) {

        if(i==n)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,str)){
                int cost=1+recursion(j+1,str,n);
                min=Math.min(min,cost);
            }
        }
        return min;
        //TC:O(exponential)
    }

    private static boolean isPalindrome(int i, int j, String str) {

        while(i<j){
            if(str.charAt(i)!= str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
