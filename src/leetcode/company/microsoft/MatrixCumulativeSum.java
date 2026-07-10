package leetcode.company.microsoft;

public class MatrixCumulativeSum {

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Solution sol = new Solution();
        int[][] result = sol.buildPrefixSum(A);

        // print result matrix
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] buildPrefixSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] M = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                M[i][j] = A[i][j];

                if (i > 0)
                    M[i][j] += M[i - 1][j];

                if (j > 0)
                    M[i][j] += M[i][j - 1];

                if (i > 0 && j > 0)
                    M[i][j] -= M[i - 1][j - 1];
            }
        }

        return M;
    }
}
