package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP29LC1312MinimumInsertionsToMakePalindrome {

    public static void main(String[] args) {

        String s ="leetcode";
        int n=s.length();

        StringBuilder sb=new StringBuilder(s);
        String sReverse=sb.reverse().toString();

        int index1=s.length();
        int index2=sReverse.length();

        //Recursion
        System.out.println(n-recursion(s, sReverse, index1-1, index2-1));

        //Memoization
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(n-memoization(s, sReverse, index1-1, index2-1, dp));

        //Tabulation
        int[][] dp1=new int[index1+1][index2+1];
        System.out.println(n-tabulation(s,sReverse,index1,index2,dp1));

        //Space
        System.out.println(n-space(s,sReverse,index1,index2));

        //Solution
        //Length of the original string - length of the longest palindromic subsequence is the answer
    }

    private static int space(String s1, String s2, int index1, int index2) {

        int[] prev=new int[index2+1];
        for(int j=0;j<=index2;j++)
            prev[j]=0;

        for(int ind1=1;ind1<=index1;ind1++){
            int[] curr=new int[index2+1];
            for(int ind2=1;ind2<=index2;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    curr[ind2]=1+prev[ind2-1];
                else
                    curr[ind2]=Math.max(prev[ind2],curr[ind2-1]);
            }
            prev=curr;
        }
        return prev[index2];
    }

    private static int tabulation(String s1, String s2, int index1, int index2, int[][] dp1) {

        for(int i=0;i<=index1;i++)
            dp1[i][0]=0;

        for(int j=0;j<=index2;j++)
            dp1[0][j]=0;
        for(int ind1=1;ind1<=index1;ind1++){
            for(int ind2=1;ind2<=index2;ind2++){

                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                     dp1[ind1][ind2]=1+dp1[ind1-1][ind2-1];
                else
                    dp1[ind1][ind2]=Math.max(dp1[ind1-1][ind2],dp1[ind1][ind2-1]);
            }
        }
        return dp1[index1][index2];
    }

    private static int memoization(String s1, String s2, int index1, int index2, int[][] dp) {

        if(index1<0 || index2<0)
            return 0;
        if(dp[index1][index1]!=-1)
            return dp[index1][index2];

        if(s1.charAt(index1)==s2.charAt(index2))
            return dp[index1][index2]=1+memoization(s1,s2,index1-1,index2-1,dp);
        return dp[index1][index2]=Math.max(memoization(s1,s2,index1-1,index2,dp),memoization(s1,s2,index1,index2-1,dp));
    }

    private static int recursion(String s1, String s2, int index1, int index2) {

        if(index1<0 || index2<0)
            return 0;
        if(s1.charAt(index1)==s2.charAt(index2))
            return 1+recursion(s1,s2,index1-1,index2-1);
        return Math.max(recursion(s1,s2,index1-1,index2),recursion(s1,s2,index1,index2-1));
    }
}
