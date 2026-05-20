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

		System.out.println("==============================================");

		//We have approach2 below where only reversal logic changes
		//rotateApproach2() function
		int[][] matrix1 = new int[][] { { 5,1,9,11 }, { 2,4, 8, 10 }, { 13,3, 6, 7 }, { 15,14, 12, 16 } };

		for (int[] row : matrix1) {
			System.out.print(row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
			System.out.println();
		}

		rotateApproach2(matrix1);

		System.out.println("After rotation: ");

		for (int[] row : matrix1) {
			System.out.print(row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
			System.out.println();
		}
	}

	private static void rotate(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;
		//we go n-1 as the matrix will be sorted once we parse that much
		// we can even go till n for i look as j will fail
		for (int i = 0; i < n-1; i++) {

			//since diagonals remain intact we start from i+1
			for (int j = i+1; j < m; j++) {  //we can also use for(int j=0; j<i;j++)
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}

		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][m - 1 - j];
				matrix[i][m - 1 - j] = temp;
			}
		}

		//TC:O(M*N)+O(M*N)
		//SC:O(1)
	}

	private static void rotateApproach2(int[][] matrix) {

		int n=matrix.length;
		int m=matrix[0].length;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<m;j++){ // we can also use for(int j=0; j<i;j++)
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}

		for(int i=0;i<n;i++){
			reverse(0, n-1, matrix[i]);
		}
	}

	public static void reverse(int left, int right, int[] matrix){
		while(left<right){
			int temp=matrix[left];
			matrix[left]=matrix[right];
			matrix[right]=temp;
			left++;
			right--;
		}
	}
}
