package leetcode.dynamicprogramming;

public class DP10LC64MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;

        System.out.println(recursion(n - 1, m - 1, grid));

        //Memoization
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization(n - 1, m - 1, dp, grid));

        //Tabulation
        int[][] dp1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp1[i][j] = -1;
            }
        }
        System.out.println(tabulation(n, m, dp1, grid));
    }

    private static int tabulation(int n, int m, int[][] dp1, int[][] grid) {

        dp1[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp1[i][j] = grid[i][j];
                else {
                    int up = (int)(10e9), left = (int)(10e9);
                    if (i > 0)
                        up = grid[i][j] + dp1[i - 1][j];
                    else
                        up=(int)(1e9);//so that current path is neglected
                    if (j > 0)
                        left = grid[i][j] + dp1[i][j - 1];
                    else
                        left=(int)(1e9);//so that current path is neglected
                    dp1[i][j] = Math.min(up, left);
                }
            }
        }
        return dp1[n - 1][m - 1];
        //TC:O(m*n)
        //TC:O(n*m) dp array
    }

    private static int memoization(int n, int m, int[][] dp, int[][] grid) {

        if (n == 0 && m == 0)
            return grid[0][0];

        if (n < 0 || m < 0)
            return (int) (1e9);

        if (dp[n][m] != -1)
            return dp[n][m];

        int up = grid[n][m] + memoization(n - 1, m, dp, grid);
        int left = grid[n][m] + memoization(n, m - 1, dp, grid);
        return dp[n][m] = Math.min(up, left);
        //TC:O(m*n)
        //TC:O(path length i.e n-1+m-1)+O(n*m) dp array
    }

    private static int recursion(int n, int m, int[][] grid) {

        if (n == 0 && m == 0)
            return grid[0][0];

        if (n < 0 || m < 0)
            return (int) (1e9);

        int up = grid[n][m] + recursion(n - 1, m, grid);
        int left = grid[n][m] + recursion(n, m - 1, grid);
        return Math.min(up, left);
        //TC:O(2 raise to n*m)
        //TC:O(path length i.e n-1+m-1)

    }
}

