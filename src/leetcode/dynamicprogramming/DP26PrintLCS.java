package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP26PrintLCS {

    public static void main(String[] args) {

        String text1 = "bbabcbcab", text2 = "bacbcbabb";

        int index1=text1.length();
        int index2=text2.length();

        //Recursion
        System.out.println(recursion(text1, text2,index1-1,index2-1));

        //Memoization
        int[][] dp1=new int[index1+1][index2+1];
        for(int[] r : dp1)
            Arrays.fill(r,-1);
        System.out.println(memoization(text1, text2,index1-1, index2-1, dp1));

        //Tabulation
        int[][] dp2=new int[index1+1][index2+1];
        System.out.println(tabulation(text1,text2,index1,index2,dp2));

        int i=index1;
        int j=index2;

        char[] ch=new char[dp2[index1][index2]]; //last cell determines the len of LCS so we used it here
        int k=ch.length-1;
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ch[k]=text1.charAt(i-1);
                k--;
                i--;j--;
            }else if(dp2[i-1][j] > dp2[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        String str=new String(ch);
        System.out.println(str);
    }

    private static int tabulation(String text1, String text2, int index1, int index2, int[][] dp) {

        for(int i=0;i<=index1;i++)
            dp[i][0]=0;
        for(int j=0;j<=index2;j++)
            dp[0][j]=0;

        for(int ind1=1;ind1<=index1;ind1++){
            for(int ind2=1;ind2<=index2;ind2++){
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1))
                    dp[ind1][ind2] =1+dp[ind1-1][ind2-1];
                else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);

            }
        }
        return dp[index1][index2];

        //TC:O(index1*index2)
        //SC:O(index1*index2) dp array
    }

    private static int memoization(String text1, String text2, int index1, int index2,int[][] dp) {

        if(index1<0||index2<0) return 0;

        if(dp[index1][index2]!=-1)
            return dp[index1][index2];

        if(text1.charAt(index1)==text2.charAt(index2))
            return dp[index1][index2] =1+recursion(text1,text2,index1-1,index2-1);
        return dp[index1][index2]=Math.max(recursion(text1,text2,index1-1,index2),recursion(text1,text2,index1,index2-1));

        //TC:O(index1*index2)
        //SC:O(index1+index2)+O(index1*index2) dp array
    }

    private static int recursion(String text1, String text2, int index1, int index2) {

        if(index1<0||index2<0) return 0;
        if(text1.charAt(index1)==text2.charAt(index2))
            return 1+recursion(text1,text2,index1-1,index2-1);

        return Math.max(recursion(text1,text2,index1-1,index2),recursion(text1,text2,index1,index2-1));

        //TC:O(2 raise index1*2 raise to index2)
        //SC:O(index1+index2)
    }
}
