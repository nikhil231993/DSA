package leetcode.array.medium;

public class LC48RotateImage {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int[] row : matrix) {
			System.out.print(row[0] + " " + row[1] + " " + row[2]);
			System.out.println();
		}
		
		rotate(matrix);

		System.out.println("After rotation: ");

		for (int[] row : matrix) {
			System.out.print(row[0] + " " + row[1] + " " + row[2]);
			System.out.println();
		}
	}

	private static void rotate(int[][] matrix) {

		//we go n-1 as the matrix will be sorted once we parse that much
		for (int i = 0; i < matrix.length-1; i++) {

			//since diagonals remain intact we start from i+1
			for (int j = i+1; j < matrix[0].length; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}

		//TC:O(M*N)+O(M*N)
		//SC:O(1)
	}
}
