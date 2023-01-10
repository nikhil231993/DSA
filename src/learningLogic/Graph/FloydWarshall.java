package learningLogic.Graph;

import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices i.e n: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges i.e m: ");
		int m = scan.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		adjacencyMatrix(arr, n, m, scan);

		floydWarshall(arr, n, m);
		scan.close();

	}

	private static void floydWarshall(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
//				if (i == j)
//					arr[i][j] = 0;
				if (arr[i][j] == 0 && i != j)
					arr[i][j] = 100000000;

			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = Math.min(arr[i][j], (arr[i][k] + arr[k][j]));
				}
			}

		}

		// If 10000000 replace it with -1
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 100000000)
					arr[i][j] = -1;

			}
		}
		printMatrix(arr, n, m);

		// to check negative cycle

		for (int i = 0; i < n; i++) {
			if (arr[i][i] < 0)
				System.out.println("Negative cycle present");
		}

	}

	private static void adjacencyMatrix(int[][] arr, int n, int m, Scanner scan) {
		System.out.println("Enter the edges now: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge:");
			int u = scan.nextInt();
			int v = scan.nextInt();
			System.out.println("Enter the weight : ");
			int w = scan.nextInt();
			arr[u][v] = w;

		}
		printMatrix(arr, n, m);

	}

	private static void printMatrix(int[][] arr, int n, int m) {
		System.out.println("The adjacency Matrix is: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
