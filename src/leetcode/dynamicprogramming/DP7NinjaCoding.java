package leetcode.dynamicprogramming;

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
        //SC:O(N) stack+O(N*4)

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
