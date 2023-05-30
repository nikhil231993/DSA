package leetcode.dynamicprogramming;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class DP24RodCutting {

    public static void main(String[] args) {
        int price[] = {1,5,8,9,10,17,17,20};

        int n = 8;

        //Recursion
        System.out.println(recursion(n-1,price,n));

        //Memoization
        int[][] dp=new int[n][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n-1,price,n,dp));

        //Memoization
        int[][] dp1=new int[n][n+1];
        for(int[] r:dp1)
            Arrays.fill(r,0);
        System.out.println(tabulation(n,price,n,dp1));

        System.out.println(space(n,price,n));

    }

    private static int space(int n, int[] price, int N) {
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];

        for(int rl=0;rl<=N;rl++)
           prev[rl]=rl*price[0];

        for(int i=1;i<n;i++){
            for(int tar=0;tar<=N;tar++){
                int np=0+prev[tar];
                int p=-(int)(1e9);
                int rodLength=i+1;
                if(rodLength<=tar)
                    p=price[i]+curr[tar-rodLength];
                curr[tar]=Math.max(p,np);
            }
            prev=curr;
        }
        return prev[N];
        //TC:O(N*m)
        //SC:O(N)dp i.e price N
    }

    private static int tabulation(int n, int[] price, int N, int[][] dp1) {
    for(int rl=0;rl<=N;rl++)
        dp1[0][rl]=rl*price[0];

    for(int i=1;i<n;i++){
        for(int tar=0;tar<=N;tar++){
            int np=0+dp1[i-1][tar];
            int p=-(int)(1e9);
            int rodLength=i+1;
            if(rodLength<=tar)
                p=price[i]+dp1[i][tar-rodLength];
             dp1[i][tar]=Math.max(p,np);
        }
    }
        return dp1[n-1][N];
        //TC:O(N*m)
        //SC:O(N*m)dp array i.e price N
    }

    private static int memoization(int i, int[] price, int n, int[][] dp) {
        if(i==0){
            return n*price[i];
        }

        if(dp[i][n]!=-1)
            return dp[i][n];

        int np=0+recursion(i-1,price,n);
        int p=-(int)(1e9);
        int rodLength=i+1;
        if(rodLength<=n)
            p=price[i]+recursion(i,price,n-rodLength);

        return dp[i][n]=Math.max(p,np);

        //TC:O(N*m)
        //SC:O(N*m)dp array+O(N) stack i.e price N
    }

    private static int recursion(int i, int[] price,int n) {

        if(i==0){
            return n*price[i];
        }

        int np=0+recursion(i-1,price,n);
        int p=-(int)(1e9);
        int rodLength=i+1;
        if(rodLength<=n)
            p=price[i]+recursion(i,price,n-rodLength);

        return Math.max(p,np);

        //TC:>>O(N) exponential
        //SC:>>O(N) i.e price N
    }
}
