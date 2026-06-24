package leetcode.company.microsoft;

import java.util.Arrays;

public class LC678ValidParenthesisWithStar {

    public static void main(String[] args) {

        String s="(**)";
        System.out.println(checkValidString(s));

        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] r: dp)
            Arrays.fill(r, -1);
        System.out.println(memoization(s, 0, 0, n, dp));

        //Best Approach https://www.youtube.com/watch?v=cHT6sG_hUZI
        System.out.println(checkValidStringOptimised(s));
    }

    private static boolean checkValidString(String s) {
        int n=s.length();
        return recursion(s, 0, 0, n);
    }

    private static boolean recursion(String s, int i, int count, int n){
        if(count<0)
            return false;
        if(i==n)
            return count==0;

        if(s.charAt(i)=='(')
            return recursion(s, i+1, count+1, n);
        else if(s.charAt(i)==')')
            return recursion(s, i+1, count-1, n);
        return recursion(s, i+1, count+1, n)|| recursion(s, i+1, count-1, n) || recursion(s, i+1, count, n);

        //TC:O(3 raise to N)
        //SC:O(N) recursion stack
    }

    private static boolean memoization(String s, int i, int count, int n, int[][] dp){
        if(count < 0)
            return false;
        if(i == n)
            return count == 0;
        if(dp[i][count] != -1)
            return dp[i][count] == 1;

        if(s.charAt(i) == '(') {
            // Added return
            return (dp[i][count] = memoization(s, i + 1, count + 1, n, dp) ? 1 : 0) == 1;
        } else if(s.charAt(i) == ')') {
            // Added return
            return (dp[i][count] = memoization(s, i + 1, count - 1, n, dp) ? 1 : 0) == 1;
        } else {
            // Put the wildcard logic in an explicit 'else' block
            dp[i][count] = (memoization(s, i + 1, count + 1, n, dp) ||
                    memoization(s, i + 1, count - 1, n, dp) ||
                    memoization(s, i + 1, count, n, dp)) ? 1 : 0;
        }

        return dp[i][count] == 1;
        //TC:O(n square)
        //SC:O(n square)
    }

    private static boolean checkValidStringOptimised(String s) {
        int n=s.length();

        int min=0, max=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }else if(s.charAt(i)==')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min<0) min=0;
            if(max<0) return false;
        }
        return min==0;
    }
}
