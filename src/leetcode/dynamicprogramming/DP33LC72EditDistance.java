package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP33LC72EditDistance {

    public static void main(String[] args) {

        String word1 = "horse", word2 = "ros";
        int index1=word1.length();
        int index2=word2.length();

        //Recursion
        System.out.println(recursion(word1,word2,index1,index2));

        //Memoization
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(word1,word2,index1,index2,dp));

        //Tabulation
        int[][] dp1=new int[index1+1][index2+1];
        System.out.println(tabulation(word1,word2,index1,index2,dp1));

        //Space
        System.out.println(space(word1,word2,index1,index2));
    }

    private static int space(String s1, String s2, int index1, int index2) {

        int[] prev=new int[index2+1];

        for(int i=0;i<=index1;i++)// we do not need this as we need only previous
            prev[0]=i;
        for(int j=0;j<=index2;j++)
            prev[j]=j;

        for(int i=1;i<=index1;i++){
            int[] curr=new int[index1+1];
            curr[0]=i; // no of operations to make "hor" to "" will be two whereas in DP 32 it was no of ways we set to 1
            for(int j=1;j<=index2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    curr[j]= prev[j-1];
                else curr[j]=1+Math.min(curr[j-1],
                        Math.min(prev[j],prev[j-1]));
            }
            prev=curr;
        }
        return prev[index2];
    }

    private static int tabulation(String s1, String s2, int index1, int index2, int[][] dp1) {

        for(int i=0;i<=index1;i++)
            dp1[i][0]=i;
        for(int j=0;j<=index2;j++)
            dp1[0][j]=j;

        for(int i=1;i<=index1;i++){
            for(int j=1;j<=index2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp1[i][j]= dp1[i-1][j-1];
                else dp1[i][j]=1+Math.min(dp1[i][j-1],
                        Math.min(dp1[i-1][j],dp1[i-1][j-1]));
            }
        }
        return dp1[index1][index2];
    }

    private static int memoization(String s1, String s2, int index1, int index2,int[][] dp) {

        if(index1==0)
            return index2;

        if(index2==0)
            return index1;

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(s1.charAt(index1-1)==s2.charAt(index2-1))
            return dp[index1][index2]= memoization(s1,s2,index1-1,index2-1,dp);

        return dp[index1][index2]=1+Math.min(memoization(s1,s2,index1,index2-1,dp),
                Math.min(memoization(s1,s2,index1-1,index2,dp),memoization(s1,s2,index1-1,index2-1,dp)));

    }

    private static int recursion(String s1, String s2, int index1, int index2) {

        if(index1==0) //it is index<0 then then shifted by 1 here and also in return statement
            return index2;
        if(index2==0)
            return index1;

        if(s1.charAt(index1-1)==s2.charAt(index2-1))
            return 0+recursion(s1,s2,index1-1,index2-1);
        return 1+Math.min(recursion(s1,s2,index1,index2-1),//Insert where a character is inserted before the prev character so only index2 moves
                Math.min(recursion(s1,s2,index1-1,index2), // Delete the character and move index1
                        recursion(s1,s2,index1-1,index2-1))); // replace guarantees with same value so both index moves

        //For insert example i=-1 for s1=horse and j=1 for ros means we need to insert j+1
        //minimum operations to convert empty string to "ro"

        //for delete if s2 gets exhausted s1=horse and s2=ros
        //minimum operations to convert hor to empty String
        //check at 21:32
        //TC:mostly exponential...O(3 raise to N * 3 raise to N)
        //SC:O(N+M) where n amd m are index 1 and index 2 resp
    }
}
