package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP7NinjaCoding {

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{10,40,70},
                {20,50,80},
                {30,60,90}};
        int n=matrix.length;

        System.out.println(recursion(matrix,n-1,3));

        //Memoization
        int[][] dp=new int[n][4];

        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(memoization(matrix,dp,n-1,3));
        //TC:O(N*4*3)
        //SC:O(N) stack+O(N*4)dp array

        int[][] dp1=new int[n][4];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(tabulation(dp1,n,matrix));

        //Space optimization
        System.out.println(space(n,matrix));

    }

    private static int space(int n, int[][] matrix) {

        int[] prev=new int[4];
        //base case
        prev[0]=Math.max(matrix[0][1],matrix[0][2]);
        prev[1]=Math.max(matrix[0][0],matrix[0][2]);
        prev[2]=Math.max(matrix[0][1],matrix[0][0]);
        prev[3]=Math.max(Math.max(matrix[0][0],matrix[0][1]),matrix[0][2]);

        for(int day=1;day<n;day++){
            int[] current=new int[4];
            for(int last=0;last<=3;last++){
                int max=0;
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int points=matrix[day][task]+prev[task];
                        max=Math.max(points,max);
                    }
                }
                current[last]=max;
            }
            prev=current;
        }
        return prev[3];
        //SC:O(N*4)
        //TC:O(4)
    }

    private static int tabulation(int[][] dp1, int n,int[][] matrix) {

        //base case
        dp1[0][0]=Math.max(matrix[0][1],matrix[0][2]);
        dp1[0][1]=Math.max(matrix[0][0],matrix[0][2]);
        dp1[0][2]=Math.max(matrix[0][1],matrix[0][0]);
        dp1[0][0]=Math.max(Math.max(matrix[0][0],matrix[0][1]),matrix[0][2]);

        for(int day=1;day<n;day++){
            for(int last=0;last<=3;last++){
                int max=0;
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int points=matrix[day][task]+dp1[day-1][task];
                        max=Math.max(points,max);
                    }
                }
                 dp1[day][last]=max;
            }
        }
        return dp1[n-1][3];
        //TC:O(N*4*3)
        //SC:O(N*4)
    }

    private static int memoization(int[][] matrix, int[][] dp, int n, int last) {

        if(n==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(max,matrix[0][i]);
                }
            }
            return max;
        }

        if(dp[n][last]!=-1)
            return dp[n][last];

        int max=0;

        for(int i=0;i<3;i++){
            if(i!=last){
                int points=matrix[n][i]+memoization(matrix,dp,n-1,i);
                max=Math.max(points,max);
            }
        }
        return dp[n][last]=max;

    }

    private static int recursion(int[][] matrix, int n, int last) {

        if(n==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(matrix[0][i],max);
                }
            }
            return max;
        }

        int max=0;
        for(int i=0;i<3;i++){
            if(i!=last) {
                int points = matrix[n][i] + recursion(matrix, n - 1, i);
                max = Math.max(points, max);
            }
        }
        return max;
    }
}
