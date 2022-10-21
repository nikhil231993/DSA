package revision.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraph {

	public void createGraph() {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices: ");
		int n = scan.nextInt();
		System.out.println("Entee the number of edges: ");
		int m = scan.nextInt();
		for (int i = 0; i <= n; i++)
			arr.add(new ArrayList<Integer>());

		System.out.println("Enter the combination of edges: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		scan.close();

		System.out.println("Printing each vertice and associated edges: ");
		for (int i = 1; i <= n; i++) {
			for (Integer num : arr.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		System.out.println("BFS Traversal of Graph: ");
		ArrayList<Integer> result = bfsTraversal(arr, n);
		for (Integer num : result) {
			System.out.println(num + " ");
		}

	}

	private ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> arr, int n) {
		ArrayList<Integer> finalBfsOrder = new ArrayList<Integer>();
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				Queue<Integer> q = new LinkedList();
				q.add(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					Integer num = q.poll();
					finalBfsOrder.add(num);
					for (Integer it : arr.get(num)) {
						if (visited[it] == false) {
							visited[it] = true;
							q.add(it);
						}
					}
				}
			}

		}
		return finalBfsOrder;

	}

}
