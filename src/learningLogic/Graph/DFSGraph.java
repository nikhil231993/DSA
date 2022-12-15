package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFSGraph {

	public void createGraph() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices:  i.e n: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges: i.e m: ");
		int m = scan.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 1; i <= n + 1; i++)
			arr.add(new ArrayList<Integer>());

		System.out.println("Enter the edges: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();

			arr.get(u).add(v);
			arr.get(v).add(u);
		}

		System.out.println("Disconnected Graph: ");
		ArrayList<Integer> responseDfsDisconnectedGraph = dfsDisconnectedGraph(arr, n, m);
		for (Integer num : responseDfsDisconnectedGraph) {
			System.out.println(num + " ");
		}

		System.out.println("Connected Graph: ");
		ArrayList<Integer> responseDfsConnectedGraph = dfsConnectedGraph(arr, n, m);
		for (Integer num : responseDfsConnectedGraph) {
			System.out.println(num + " ");
		}

		System.out.println("Disconnected Graph Using Stack: ");
		ArrayList<Integer> responseBfsDisconnectedGraphUsingStack = dfsDisconnectedGraphUsingStack(arr, n, m);
		for (Integer num : responseBfsDisconnectedGraphUsingStack) {
			System.out.println(num + " ");
		}

		printGraph(arr, n);
		scan.close();
	}

	private ArrayList<Integer> dfsDisconnectedGraphUsingStack(ArrayList<ArrayList<Integer>> arr, int n, int m) {
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				st.push(i);
				while (!st.isEmpty()) {

					Integer num = st.pop();
					dfs.add(num);
					for (Integer vertices : arr.get(num)) {
						if(visited[vertices]==false) {
							visited[vertices]=true;
							st.push(vertices);
							
						}
					}
				}


			}
		}
		return dfs;
	}

	private ArrayList<Integer> dfsConnectedGraph(ArrayList<ArrayList<Integer>> arr, int n, int m) {
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		boolean[] visited = new boolean[n + 1];
		// for (int i = 1; i <= n; i++) {
		if (visited[1] == false) {
			dfsConnectedGraphRecursive(dfs, visited, 1, arr);
			}
		// }
		return dfs;
	}

	private void dfsConnectedGraphRecursive(ArrayList<Integer> dfs, boolean[] visited, int i,
			ArrayList<ArrayList<Integer>> arr) {
		visited[i]=true;
		dfs.add(i);
		for (Integer vertices : arr.get(i)) {
			if (visited[vertices] == false) {
				dfsConnectedGraphRecursive(dfs, visited, vertices, arr);
			}
		}

	}

	private ArrayList<Integer> dfsDisconnectedGraph(ArrayList<ArrayList<Integer>> arr, int n, int m) {
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (visited[i] == false)
				recursiveDfsDisconnectedGraph(dfs, visited, i, arr);
		}
		return dfs;

	}

	private void recursiveDfsDisconnectedGraph(ArrayList<Integer> dfs, boolean[] visited, int i,
			ArrayList<ArrayList<Integer>> arr) {
		visited[i] = true;
		dfs.add(i);
		for (Integer vertex : arr.get(i)) {
			if (visited[vertex] == false) {
				recursiveDfsDisconnectedGraph(dfs, visited, vertex, arr);
			}
		}

	}

	private void printGraph(ArrayList<ArrayList<Integer>> arr, int n) {
		System.out.println("Priting graph: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " --> ");
			for (Integer num : arr.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}
