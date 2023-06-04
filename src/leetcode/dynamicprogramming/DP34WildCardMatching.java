package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP34WildCardMatching {

    public static void main(String[] args) {
        String pattern = "*", input = "aa";

        int index1=pattern.length();
        int index2=input.length();

        //Recursion
        System.out.println(recursion(pattern,input,index1,index2));

        //Memoization
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(pattern,input,index1,index2,dp));

        //Tabulation
        boolean[][] dp1=new boolean[index1+1][index2+1];
        System.out.println(tabulation(pattern,input,index1,index2,dp1));

        //Space
        System.out.println(space(pattern,input,index1,index2));
    }

    private static boolean space(String pattern, String input, int index1, int index2) {

        boolean[] prev=new boolean[index2+1];

        prev[0]=true;
        for(int j=1;j<=index2;j++)
            prev[j]=false;

        for(int i=1;i<=index1;i++){
            boolean[] curr=new boolean[index2+1];
                boolean flag=true;
                for(int ii=1;ii<=i;ii++){
                    if(pattern.charAt(ii-1)!='*'){
                        flag=false;
                        break;
                    }
               curr[0] =flag;
            }
            for(int j=1;j<=index2;j++){
                if(pattern.charAt(i-1)==input.charAt(j-1) || pattern.charAt(i-1)=='?')
                    curr[j]=prev[j-1];
                else if(pattern.charAt(i-1)=='*')
                     curr[j]=(prev[j] || curr[j-1]);
                else
                    curr[j]=false;
            }
            prev=curr;
        }
        return prev[index2];
    }

    private static boolean tabulation(String pattern, String input, int index1, int index2, boolean[][] dp1) {

        dp1[0][0]=true;
        for(int j=1;j<=index2;j++)
            dp1[0][j]=false;

        for(int i=1;i<=index1;i++){
            boolean flag=true;
            for(int ii=1;ii<=i;ii++){
                if(pattern.charAt(ii-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp1[i][0] =flag;
        }

        for(int i=1;i<=index1;i++){
            for(int j=1;j<=index2;j++){
                if(pattern.charAt(i-1)==input.charAt(j-1) || pattern.charAt(i-1)=='?')
                     dp1[i][j]=dp1[i-1][j-1];
                else if(pattern.charAt(i-1)=='*')
                     dp1[i][j]=(dp1[i-1][j] || dp1[i][j-1]);
                else
                    dp1[i][j]=false;
            }
        }
        return dp1[index1][index2];
    }

    private static int memoization(String pattern, String input, int index1, int index2,int[][] dp) {
        if(index1==0 && index2==0)
            return 1;
        if(index1==0 && index2>0)
            return 0;
        if(index2==0 && index1>0)
        {
            for(int i=1;i<=index1;i++){
                if(pattern.charAt(i-1)!=-1)
                    return 0;
            }
            return 1;
        }

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(pattern.charAt(index1-1)==input.charAt(index2-1) || pattern.charAt(index1-1)=='?')
            return dp[index1][index2]=memoization(pattern,input,index1-1,index2-1,dp);
        if(pattern.charAt(index1-1)=='*')
            return dp[index1][index2]=(memoization(pattern,input,index1-1,index2,dp)==1
                    || memoization(pattern,input,index1,index2-1,dp)==1)?1:0;
        return 0;
    }

    private static boolean recursion(String pattern, String input, int index1, int index2) {

        if(index1==0 && index2==0)
            return true;
        if(index1==0 && index2>0)
            return false;
        if(index2==0 && index1>0){
            for(int i=1;i<=index1;i++){
                if(pattern.charAt(i-1)!='*')
                    return false;
            }
            return true;
        }

        if(input.charAt(index2-1)==pattern.charAt(index1-1) || pattern.charAt(index1-1)=='?')
            return recursion(pattern,input,index1-1,index2-1);
        if(pattern.charAt(index1-1)=='*')
            return recursion(pattern,input,index1-1,index2)|| recursion(pattern,input,index1,index2-1);
        return false;

        //TC: exponential
        //SC:o(N+M)
    }
}
