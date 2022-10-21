package revision.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFSGraph {

	public void createGraph() {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices: ");
		int n = scan.nextInt();
		System.out.println("Entee the number of edges: ");
		int m = scan.nextInt();
		for (int i = 0; i < n; i++)
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
		for (int i = 0; i < n; i++) {
			for (Integer num : arr.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		System.out.println("DFS Traversal of Connected Nodes Graph: ");
		ArrayList<Integer> result = dfsTraversalConnectedNodes(arr, 0, n);
		for (Integer num : result) {
			System.out.println(num + " ");
		}

		System.out.println("DFS Traversal of DisConnected Nodes Graph: ");
		ArrayList<Integer> resultDisconnected = dfsTraversalDisConnectedNodes(arr, n);
		for (Integer num : resultDisconnected) {
			System.out.println(num + " ");
		}

		System.out.println("DFS Traversal of Connected Nodes Graph USing Stack: ");
		ArrayList<Integer> resultConnectedUsingStack = dfsTraversalConnectedNodesWithStack(arr, n);
		for (Integer num : resultConnectedUsingStack) {
			System.out.println(num + " ");
		}

		System.out.println("DFS Traversal of DisConnected Nodes Graph Using Stack: ");
		ArrayList<Integer> resultDisconnectedUsingStack = dfsTraversalDisConnectedNodesWithStack(arr, n);
		for (Integer num : resultDisconnectedUsingStack) {
			System.out.println(num + " ");
		}

	}

	private ArrayList<Integer> dfsTraversalDisConnectedNodesWithStack(ArrayList<ArrayList<Integer>> arr, int n) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				Stack<Integer> stack = new Stack<>();
				stack.push(i);

				while (!stack.isEmpty()) {
					Integer num = stack.pop();
					dfs.add(num);
					for (Integer conectedVertex : arr.get(num)) {
						if (visited[conectedVertex] == false) {
							visited[conectedVertex] = true;
							stack.push(conectedVertex);

						}
					}
				}
			}
		}

		return dfs;
	}

	private ArrayList<Integer> dfsTraversalConnectedNodesWithStack(ArrayList<ArrayList<Integer>> arr, int n) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[n];
		visited[0] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			Integer num = stack.pop();
			dfs.add(num);
			for (Integer conectedVertex : arr.get(num)) {
				if (visited[conectedVertex] == false) {
					visited[conectedVertex] = true;
					stack.push(conectedVertex);

				}
			}
		}

		return dfs;
	}

	private ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> arr, int n) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				recursive(arr, i, visited, dfs);
			}

		}
		return dfs;
	}

	private ArrayList<Integer> dfsTraversalConnectedNodes(ArrayList<ArrayList<Integer>> arr, int vertex, int n) {
		boolean visited[] = new boolean[n];
		ArrayList<Integer> dfs = new ArrayList<>();
		return recursive(arr, vertex, visited, dfs);
	}

	private ArrayList<Integer> recursive(ArrayList<ArrayList<Integer>> arr, int vertex, boolean visited[],
			ArrayList<Integer> dfs) {

		dfs.add(vertex);
		visited[vertex] = true;
		for (Integer num : arr.get(vertex)) {
			if (visited[num] == false)
				recursive(arr, num, visited, dfs);
		}

		return dfs;

	}

}
