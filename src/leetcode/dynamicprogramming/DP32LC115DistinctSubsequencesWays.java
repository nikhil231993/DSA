package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP32LC115DistinctSubsequencesWays {

    public static void main(String[] args) {

        //String s = "rabbbit", t = "";
        String s="ba",t="b";

        int index1=s.length();
        int index2=t.length();

        //Recursion
        System.out.println(recursion(s,t,index1,index2));

        //Memoization
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(s,t,index1,index2,dp));

        //Tabulation
        int[][] dp1=new int[index1+1][index2+1];
        System.out.println(tabulation(s,t,index1,index2,dp1));

        //space
        System.out.println(space(s,t,index1,index2));
    }

    private static int space(String s, String t, int index1, int index2) {

        int[] prev=new int[index2+1];
        prev[0]=1;

        for(int j=1;j<=index2;j++) // we don't need this as it is already set to 0
            prev[j]=0;

        for(int ind1=1;ind1<=index1;ind1++){
            int[] curr=new int[index2+1];
            curr[0]=1;
            for(int ind2=1;ind2<=index2;ind2++){
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    curr[ind2]=prev[ind2-1]+prev[ind2];
                }else{
                    curr[ind2]=prev[ind2];
                }
            }
            prev=curr;
        }
        return prev[index2];
    }

    private static int tabulation(String s, String t, int index1, int index2, int[][] dp1) {

        for(int i=0;i<=index1;i++)
            dp1[i][0]=1;
        // This is because for "rabbit" to "" where "" is a subsequence if we use "r", "ra" or any subsequence we can form ""

        //Below we start from 1 because for all j=0 it should be 1. We can even omit it as by default it is 0 same LCS where we dont have to initialize anything
        for(int j=1;j<=index2;j++)
            dp1[0][j]=0;

        for(int ind1=1;ind1<=index1;ind1++){
            for(int ind2=1;ind2<=index2;ind2++){

                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    dp1[ind1][ind2]=dp1[ind1-1][ind2-1]+dp1[ind1-1][ind2];
                }else{
                    dp1[ind1][ind2]=dp1[ind1-1][ind2];
                }
            }
        }
        return dp1[index1][index2];

        //TC:O(index1 * index2)
        //SC:O(index1*index2)
    }

    private static int memoization(String s, String t, int index1, int index2,int[][] dp) {

        if(index2==0) // it is index2 < 0 and then shifted by 1
            return 1;

        if(index1==0)
            return 0;

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(s.charAt(index1-1)==t.charAt(index2-1))
            return dp[index1][index2]=memoization(s,t,index1-1,index2-1,dp) + memoization(s,t,index1-1,index2,dp);
        return dp[index1][index2]=memoization(s,t,index1-1,index2,dp);

        //TC:O(index1 * index2)
        //SC:O(index1+index2)+O(index1*index2)
    }

    private static int recursion(String s, String t, int index1, int index2) {

        if(index2==0) // we ideally use <0 but similar to LCS we increase the index by 1
            return 1;

        if(index1==0)
            return 0;

        if(s.charAt(index1-1)==t.charAt(index2-1))
            return recursion(s,t,index1-1,index2-1) + recursion(s,t,index1-1,index2);
        return recursion(s,t,index1-1,index2);

        //TC:O(2 raise to index1 * 2 raise to index2)
        //SC:O(index1+index2)
    }
}
