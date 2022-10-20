package revision.Graph;

import java.util.Scanner;

public class AdjacencyMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scan.nextInt();
		System.out.println("Enter m: ");
		int m = scan.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		adjacencyMatrix(arr, scan, n, m);
		scan.close();
	}

	private static void adjacencyMatrix(int[][] arr,Scanner scan,int n,int m) {
		System.out.println("Enter the edges combination: ");
		for(int i=1;i<m+1;i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr[u][v] = 1;
			arr[v][u] = 1;

		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}


	}


}
