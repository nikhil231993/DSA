package leetcode.company.salesforce;

import java.util.Arrays;

public class TwoStringsSubsequenceAndSubstring {

    public static void main(String[] args) {

        String s1="aebdcf";
        String s2="abdcf";
        int index1=s1.length();
        int index2=s2.length();

        System.out.println(funcRecursion(index1-1, index2-1, s1, s2));
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r: dp)
            Arrays.fill(r, -1);
        System.out.println(funcMemoization(index1, index2, s1, s2, dp));

        int[][] dp1=new int[index1+1][index2+1];
        System.out.println(funcTabulation(index1, index2, s1, s2, dp1));

        System.out.println(funcSpace(index1, index2, s1, s2));
    }

    private static int funcSpace(int index1, int index2, String s1, String s2) {

        int[] prev=new int[index1+1];
            prev[0]=0;
        for (int j=0;j<=index2;j++)
            prev[j]=0;

        for(int i=1;i<=index1;i++){
            int[] curr=new int[index1+1];
            for(int j=1;j<=index2;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))
                    curr[j]= 1+prev[j-1];
                else
                    curr[j]= Math.max(prev[j], curr[j-1]);
            }
            prev=curr;
        }
        return prev[index2];
    }

    private static int funcTabulation(int index1, int index2, String s1, String s2, int[][] dp1) {

        for(int i=0; i<=index1;i++)
            dp1[i][0]=0;
        for (int j=0;j<=index2;j++)
            dp1[0][j]=0;

        for(int i=1;i<=index1;i++){
            for(int j=1;j<=index2;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))
                     dp1[i][j]= 1+dp1[i-1][j-1];
                else
                    dp1[i][j]= Math.max(dp1[i-1][j], dp1[i][j-1]);
            }
        }
        return dp1[index1][index2];
    }

    private static int funcMemoization(int index1, int index2, String s1, String s2, int[][] dp) {
        if(index1==0 || index2==0)
            return 0;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(s1.charAt(index1-1)==s2.charAt(index2-1))
            return dp[index1][index2]= 1+funcMemoization(index1-1, index2-1, s1, s2, dp);
        return dp[index1][index2]= Math.max(funcMemoization(index1-1, index2, s1, s2, dp), funcMemoization(index1, index2-1, s1, s2, dp));
    }

    private static int funcRecursion(int index1, int index2, String s1, String s2) {

        if(index1<0 || index2<0)
                return 0;
        if(s1.charAt(index1)==s2.charAt(index2))
            return 1+funcRecursion(index1-1, index2-1, s1, s2);
        return Math.max(funcRecursion(index1-1, index2, s1, s2), funcRecursion(index1, index2-1, s1, s2));
    }
}
