package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		List<Integer> r = spiralOrder(matrix);

		System.out.println(r);

	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> output = new ArrayList<Integer>();
		if (matrix.length == 0)
			return output;
		int top = 0;
		int left = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				output.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				output.add(matrix[i][right]);
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					output.add(matrix[bottom][i]);
				}
			}
			bottom--;
			if (left <= right) {

				for (int i = bottom; i >= top; i--) {
					output.add(matrix[i][left]);
				}
				left++;
			}
		}
		// SC:O(m*n)
		// TC:O(m*n)
		return output;
	}

}
