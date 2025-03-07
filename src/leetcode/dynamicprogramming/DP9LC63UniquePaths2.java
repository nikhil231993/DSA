package leetcode.dynamicprogramming;

public class DP9LC63UniquePaths2 {

    public static void main(String[] args) {

        int[][] obstacleGrid =new int[][] {{0,0,0},{0,1,0},{0,0,0}};

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //Recursion
        System.out.println(recursion(m-1, n-1, obstacleGrid));

        if(obstacleGrid[0][0]==1)//This is to handle test case[[1]] which means we cannot start
            System.out.println(0);

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        //Memoization
        System.out.println(memoization(m-1,n-1,dp,obstacleGrid));

        //Tabulation
        int[][] dp1=new int[m][n];
        System.out.println(tabulation(m,n,dp1,obstacleGrid));

        //Space optimization
        System.out.println(space(n,m,obstacleGrid));
    }

    private static int recursion(int n, int m, int[][] matrix){

        if(n==0 && m==0)
            return 1;
        if(n<0 || m<0) return 0;
        if(matrix[n][m]==1) return 0;

        int left=recursion(n, m-1, matrix);
        int top=recursion(n-1, m, matrix);
        return top+left;

        //TC: O(2 raise to m*n)
        //SC: O(unique paths )i.e.n+m
    }

    private static int space(int n, int m, int[][] obstacleGrid) {

        int[] prev=new int[n];

        for(int i=0;i<m;i++) {
            int[] current=new int[4];

            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1)
                    current[j]=0;
                else if(i==0 && j==0)
                    current[j]=1;
                else{
                    int left=0,up=0;
                    if(i>0)
                        up =prev[j];
                    if(j>0)
                        left=current[j-1];
                    current[j]=up+left;
                }
            }
            prev=current;
        }
        return prev[n-1];
    }

    private static int tabulation(int m, int n, int[][] dp1,int[][] obstacleGrid) {

        dp1[0][0]=1;
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {

                if(obstacleGrid[i][j]==1)
                    dp1[i][j]=0;
                else if(i==0 && j==0)
                    dp1[i][j]=1;
                else{
                    int left=0,up=0;
                    if(i>0)
                        up =dp1[i-1][j];
                    if(j>0)
                        left=dp1[i][j-1];
                    dp1[i][j]=up+left;
                }
            }
        }
        return dp1[m-1][n-1];

        //TC:O(m*n)
        //SC:O(n*m) dp arrays
    }

    private static int memoization(int m, int n, int dp[][], int[][] obstacleGrid){

        if(n==0 && m==0)
            return 1;

        if(m<0 || n<0)
            return 0;

        if(obstacleGrid[m][n]==1)
            return 0;

        if(dp[m][n]!=-1)
            return dp[m][n];

        int up = memoization(m-1,n,dp,obstacleGrid);
        int left= memoization(m,n-1,dp,obstacleGrid);

        return dp[m][n]=up+left;

        //TC:O(m*n)
        //SC:O(unique paths) i.e., O(n+m) + O(n*m) dp arrays
    }
}
