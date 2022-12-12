package learningLogic.Graph;

import java.util.Scanner;

public class AdjacencyMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices i.e n: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges i.e m: ");
		int m = scan.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		adjacencyMatrix(arr, n, m, scan);
		scan.close();

	}

	private static void adjacencyMatrix(int[][] arr, int n, int m, Scanner scan) {
		System.out.println("Enter the edges now: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge:");
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr[u][v] = 1;
			arr[v][u] = 1;


		}
		printMatrix(arr, n, m);

	}

	private static void printMatrix(int[][] arr,int n,int m) {
		System.out.println("The adjacency Matrix is: ");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
