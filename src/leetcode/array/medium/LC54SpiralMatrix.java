package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		
		List<Integer> r = spiralOrder(matrix);
		System.out.println(r);
	}

	private static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> output = new ArrayList<>();
		int n = matrix.length;
		int m = matrix[0].length;

		if (matrix.length == 0)
			return output;

		int top = 0 , left=0, right = n - 1, bottom = m - 1;

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
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					output.add(matrix[i][left]);
				}
				left++;
			}
		}
		return output;

		//SC:O(m*n)
		//TC:O(m*n)
	}
}
