package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP31LC1092ShortestCommonSupersequence {

    public static void main(String[] args) {

        String str1 = "abac", str2 = "cab";
        int index1=str1.length();
        int index2=str2.length();

        //Tabulation
        int[][] dp=new int[index1+1][index2+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);

        System.out.println(index1+index2-tabulation(str1,str2,index1,index2,dp));

        int i=index1;
        int j=index2;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        System.out.println(sb.reverse().toString());

        //we have to find the length of both string and then reduce common string
        //i.e. n+m-len(lcs) 8:28 video
    }

    private static int tabulation(String str1, String str2, int index1, int index2, int[][] dp) {

        for(int i=0;i<=index1;i++)
            dp[i][0]=0;
        for(int j=0;j<=index2;j++)
            dp[0][j]=0;

        for(int i=1;i<=index1;i++){
            for(int j=1;j<=index2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[index1][index2];
    }
}
