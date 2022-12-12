package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices i.e n: ");
		int n = scan.nextInt();
		adjacencyList(n, scan);
		scan.close();

	}

	private static void adjacencyList(int n, Scanner scan) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		System.out.println("Enter the no of edges i.e m: ");
		int m = scan.nextInt();

		for (int i = 1; i <= n + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}
		for (int i = 1; i <= m; i++) {

			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();

			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		printAdjacenyList(arr, n);

	}

	private static void printAdjacenyList(ArrayList<ArrayList<Integer>> arr,int n) {
		System.out.println("The adjacency Matrix is: ");
		for (int i = 1; i <= n; i++) {
			for (Integer edge : arr.get(i)) {
				System.out.print(edge + " ");

			}
			System.out.println();
		}
	}

}
