package leetcode.array;

import java.util.Arrays;

public class MatrixSort {

    public static void main(String[] args) {

        int[] nums=new int[]{5,4,3,2,1};
        Arrays.sort(nums);

        int[][] matrix = {
                {3, 2, 5},
                {1, 4, 7},
                {2, 8, 6}
        };

        // Sort the matrix based on the elements in the first column (column 0)
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));

        // Print the sorted matrix
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
