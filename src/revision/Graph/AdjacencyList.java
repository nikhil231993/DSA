package revision.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		adjacencyList(arr, scan, n);
		scan.close();

	}

	private static void adjacencyList(ArrayList<ArrayList<Integer>> arr, Scanner scan, int n) {
		System.out.println("Expected no of edges: ");
		int e = scan.nextInt();
		
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 1; i < e + 1; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr.get(u).add(v);
			arr.get(v).add(u);
		}

		for (int i = 0; i <= n; i++) {
			for (Integer num : arr.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}


}
