package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP25LC1143LCS { //not matching split calls 24:06

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "bdgek";

        int index1=text1.length();
        int index2=text2.length();

        //Recursion
        System.out.println(recursion(text1, text2, index1-1, index2-1));

        //Memoization
        int[][] dp=new int[index1][index2];
        for(int[] r:dp)
            Arrays.fill(r, -1);
        System.out.println(lcsMemoization(text1, text2,index1-1,index2-1, dp));

        //Tabulation
        //we can do tabulation without shifting of index, but it will be more tricky
        int[][] dp1=new int[index1+1][index2+1];
        System.out.println(tabulation(text1, text2, index1, index2, dp1));

        //space
        System.out.println(space(text1, text2, index1, index2));
    }

    private static int space(String text1, String text2, int index1, int index2) {

        int[] prev=new int[index2+1];
        for(int j=0;j<=index2;j++)
            prev[j]=0;
        //the next base case will be prev[0]=0 which is already set above so we ignored

        for(int id1=1;id1<=index1;id1++){
            int[] curr=new int[index2+1];

            for(int id2=1;id2<=index2;id2++){
                if(text1.charAt(id1-1)==text2.charAt(id2-1))
                    curr[id2]=1+prev[id2-1];
                else
                    curr[id2]=Math.max(prev[id2],curr[id2-1]);
            }
            prev=curr;
        }
        return prev[index2]; // we can return prev or curr here

        //TC:O(index1*index2)
        //SC:O(index2) prev or curr
    }

    private static int tabulation(String text1, String text2, int index1, int index2, int[][] dp1) {

        for(int i=0;i<=index1;i++)
            dp1[i][0]=0;
        for(int j=0;j<=index2;j++)
            dp1[0][j]=0;

        for(int id1=1;id1<=index1;id1++){
            for(int id2=1;id2<=index2;id2++){
                if(text1.charAt(id1-1)==text2.charAt(id2-1))
                     dp1[id1][id2]=1+dp1[id1-1][id2-1];
                else
                    dp1[id1][id2]=Math.max(dp1[id1-1][id2],dp1[id1][id2-1]);
            }
        }
        return dp1[index1][index2];

        //TC:O(index1*index2)
        //SC:O(index2*index2) dp array
    }


    public static int lcsMemoization(String text1, String text2, int index1,int index2,int[][] dp){

        if(index1<0 || index2<0)
            return 0;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2))
            return dp[index1][index2]=1+lcsMemoization(text1, text2, index1-1, index2-1, dp);
        return dp[index1][index2] = Math.max(lcsMemoization(text1, text2, index1-1, index2, dp), lcsMemoization(text1, text2, index1, index2-1, dp));

        //TC:O(index1*index2)
        //SC:O(index1+index2) stack as we omit alternate from each string at each step+
        // O(index2*index2) dp array
    }

    private static int recursion(String text1, String text2, int index1, int index2) {

        if(index1<0 || index2<0)
            return 0;
        if(text1.charAt(index1) == text2.charAt(index2))
            return 1+recursion(text1, text2, index1-1, index2-1);

        return Math.max(recursion(text1, text2, index1-1, index2), recursion(text1, text2, index1, index2-1));

        //TC:O(2^index1 * 2^index2)
        //SC:O(index1+index2) as we omit alternate from each string at each step
    }
}
