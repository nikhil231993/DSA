package leetcode.medium.array;

public class LC74Search2DArray {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;

		System.out.println(matrixSearch(matrix, target));

	}

	public static boolean matrixSearch(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int begin = 0;
		int end = row * col - 1;
		while (begin <= end) {
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid / col][mid % col];
			if (mid_value == target) {
				return true;
			} else if (mid_value < target) {
				begin = mid + 1;
			} else
				end = mid - 1;
		}
		return false;

		// SC:O(1)
		// TC:O(log n*m)

	}

}
