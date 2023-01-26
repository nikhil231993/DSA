package learningLogic.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class V16MColouringProblem {

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
			adjList.get(v).add(u);
		}

		System.out.println("Printing each vertice and associated edges: ");
		for (int i = 1; i <= n; i++) {
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

		System.out.println("Detect whether graph is bipartite or not: ");
		System.out.println(dfsBipartite(adjList, n));

		System.out.println("No of colors : ");
		int M = scan.nextInt();

		System.out.println(MColoring(adjList, n, M));
		scan.close();

	}

	private static boolean MColoring(ArrayList<ArrayList<Integer>> adjList, int n, int m) {
		int[] color=new int[n+1];
		if (solve(adjList, n, m, color, 1))
			return true;

		return false;
	}

	private static boolean solve(ArrayList<ArrayList<Integer>> adjList, int n, int m, int[] color, int node) {
		if (node == n)
			return true;
		for(int i=1;i<=m;i++) {
			if (isSafe(adjList, n, m, color, node, i)) {
				color[node] = i;
				if (solve(adjList, n, m, color, node + 1))
					return true;
				color[node] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(ArrayList<ArrayList<Integer>> adjList, int n, int m, int[] color, int node, int i) {
		for (Integer it : adjList.get(node)) {
			if (color[it] == i)
				return false;
		}
		return true;
	}

	private static boolean dfsBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {
		boolean[] visited = new boolean[n + 1];
		int[] color = new int[n + 1];
		for (int i = 1; i < n; i++) {
			if (!visited[i]) {
				color[i] = 1;
				visited[i] = true;
				if (!recursiveBipartite(adjList, n, i, visited, color))
					return false;
			}
		}
		return true;
	}

	private static boolean recursiveBipartite(ArrayList<ArrayList<Integer>> adjList, int n, int i, boolean[] visited,
			int[] color) {
		
		for (Integer num : adjList.get(i)) {
			if (!visited[num]) {
				visited[num]=true;
				color[num]=1-color[i];
				if (!recursiveBipartite(adjList, n, num, visited, color))
					return false;

			}
			else if(color[num]==color[i]) {
				return false;
				
			}
		}
		return true;

	}

	private static ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer> dfs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				recursiveDfs(adjList, n, i, visited, dfs);
			}
		}
		return dfs;
	}

	private static void recursiveDfs(ArrayList<ArrayList<Integer>> adjList, int n, int i, boolean[] visited,
			ArrayList<Integer> dfs) {
		visited[i] = true;
		dfs.add(i);
		for (Integer num : adjList.get(i)) {
			if (!visited[num])
				recursiveDfs(adjList, n, num, visited, dfs);
		}

	}

}
