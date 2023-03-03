package leetcode.medium;

public class LC59SpiralMatrix2 {

	public static void main(String[] args) {
		
		int[][] r = spiralOrder(3);// n*n n=3
		
		for(int[] rows:r)
			for(int col:rows)
				System.out.println(col);

	}

	public static int[][] spiralOrder(int n) {

		int[][] matrix = new int[n][n];
		int top = 0;
		int left = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;
		
		int value=0;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = ++value;
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				matrix[i][right] = ++value;
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					matrix[bottom][i] = ++value;
				}
			}
			bottom--;
			if (left <= right) {

				for (int i = bottom; i >= top; i--) {
					matrix[i][left] = ++value;
				}
				left++;
			}
		}
		// SC:O(m*n)
		// TC:O(m*n)
		return matrix;
	}

}
