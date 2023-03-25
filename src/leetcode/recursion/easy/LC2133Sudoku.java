package leetcode.recursion.easy;

public class LC2133Sudoku {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
		
		// 2nd input
		int[][] matrix1 = { { 1, 1, 1 }, { 1, 2, 3 }, { 1, 2, 3 } };

		System.out.println(solve(matrix1));
		// TC:O(N cube) as isValid runs inside
		// SC:O(1) no extar space
	}

	public static boolean solve(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!isValid(matrix, i, j))
					return false;
			}
		}
		return true;
	}

	public static boolean isValid(int[][] matrix, int row, int col) {
		for (int i = 0; i < matrix.length; i++) {
			if (i != col && matrix[row][i] == matrix[row][col])
				return false;
			if (i != row && matrix[i][col] == matrix[row][col])
				return false;
		}
		return true;
	}

}
