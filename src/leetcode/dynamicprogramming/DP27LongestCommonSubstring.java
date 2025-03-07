package leetcode.dynamicprogramming;

public class DP27LongestCommonSubstring {

    public static void main(String[] args) {

        String s1="abcd";
        String s2="abcde";
        s1="abcjklp";
        s2="acjkp";

        int index1=s1.length();
        int index2=s2.length();

        //Tabulation
        int[][] dp=new int[index1+1][index2+1];

        //If we go with recursion we would need one more state and will be difficult that is why we use tabulation
        //tabulation
        System.out.println(tabulation(s1,s2,index1,index2,dp));

        //Space
        System.out.println(space(s1,s2,index1,index2));
    }

    private static int space(String s1, String s2, int index1, int index2) {

        int[] prev=new int[index2+1];
        for(int j=0;j<=index2;j++)
            prev[j]=0;

        int ans=Integer.MIN_VALUE;
        for(int ind1=1;ind1<=index1;ind1++){
            int[] curr=new int[index2+1];

            for(int ind2=1;ind2<=index2;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    curr[ind2]=1+prev[ind2-1];
                    ans=Math.max(ans,curr[ind2]);
                }
                else
                    curr[ind2]=0;
            }
            prev=curr;
        }
        return ans;
    }

    private static int tabulation(String s1, String s2, int index1, int index2, int[][] dp) {

        for(int i=0;i<=index1;i++)
            dp[i][0]=0;
        for(int j=0;j<=index2;j++)
            dp[0][j]=0;

        int ans=0;
        for(int ind1=1;ind1<=index1;ind1++){
            for(int ind2=1;ind2<=index2;ind2++){

                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                    ans=Math.max(ans, dp[ind1][ind2]);
                }
                else
                    dp[ind1][ind2]=0;
            }
        }
        return ans;

        //TC:O(index1*index2)
        //SC:O(index1*index2)
    }
}
