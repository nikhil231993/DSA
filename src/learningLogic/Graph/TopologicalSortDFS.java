package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortDFS {

	public static void main(String[] args) {
		createGraph();

	}

	private static void createGraph() {
		Scanner scan = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		System.out.println("Enter the no of vertices: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges: ");
		int m = scan.nextInt();
		System.out.println("Creating ArrayLIst of ArrayList: ");
		for (int i = 0; i <= n; i++)
			adjList.add(new ArrayList<Integer>());
		System.out.println("Enter the combination of edges pair: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();

			adjList.get(u).add(v);
		}

		System.out.println("Printing each vertice and associated edges: ");
		for (int i = 0; i <= n; i++) {
			for (Integer num : adjList.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		System.out.println("DFS Traversal of DisConnected Nodes Graph: ");
		ArrayList<Integer> resultDisconnected = dfsTraversalDisConnectedNodes(adjList, n);
		for (Integer num : resultDisconnected) {
			System.out.println(num + " ");
		}

		System.out.println("Topology in DFS: ");
		dfsTopology(adjList, n);
		scan.close();

	}

	private static void dfsTopology(ArrayList<ArrayList<Integer>> adjList, int n) {
		boolean visited[]=new boolean[n+1];
		Stack<Integer> s=new Stack<Integer>();
		for (int i = 0; i <= n; i++)
		{
			if(visited[i]==false) {
				topologyRecursive(adjList, i, visited, s);
			}
		}
		System.out.println("Topology order in DFS is: ");
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

	}

	private static void topologyRecursive(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited,
			Stack<Integer> s) {
		visited[i] = true;
		for (Integer it : adjList.get(i)) {
			if (visited[it] == false) {
//				visited[it] = true;
				topologyRecursive(adjList, it, visited, s);
			}
		}
		s.push(i);

	}

	private static ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		boolean visited[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			if (visited[i] == false) {
				dfs(dfs, adjList, i, n, visited);
			}
		}
		return dfs;
	}

	private static void dfs(ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adjList, int i, int n,
			boolean visited[]) {
		visited[i] = true;
		dfs.add(i);
		for (Integer it : adjList.get(i)) {
			if (visited[it] == false)
				// visited[it] = true;
			dfs(dfs, adjList, it, n, visited);
		}

	}

}
