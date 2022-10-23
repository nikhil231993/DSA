package revision.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFSBipartite {

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
		ArrayList<Integer> resultDisconnected = bfsTraversalDisConnectedNodes(adjList, n);
		for (Integer num : resultDisconnected) {
			System.out.println(num + " ");
		}

		System.out.println("Detect whether graph is bipartite or not: ");
		System.out.println(dfsBipartite(adjList, n));
		scan.close();

	}

	private static boolean dfsBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {

		int[] colour = new int[n + 1];
		Arrays.fill(colour, -1);
		for (int i = 1; i <= n; i++) {
			if (colour[i] == -1) {
//				colour[i] = 1;
				if (!bipartiteCheck(adjList, i, colour)) {
					return false;
				}
			}
		}
		return true;

	}

	private static boolean bipartiteCheck(ArrayList<ArrayList<Integer>> adjList, int i, int[] colour) {

		if (colour[i] == -1)
			colour[i] = 1;
		for (Integer it : adjList.get(i)) {
			if (colour[it] == -1) {
				colour[it] = 1 - colour[i];
				if (!bipartiteCheck(adjList, it, colour))
				return false;
			}
			else {
				if (colour[it] == colour[i])
					return false;
			}
		}
		return true;
	}

	private static ArrayList<Integer> bfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false)
				dfsRecursive(adjList, i, visited, dfs);
		}
		return dfs;
	}

	private static void dfsRecursive(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited,
			ArrayList<Integer> dfs) {
		visited[i] = true;
		dfs.add(i);
		for (Integer it : adjList.get(i)) {
			if (visited[it] == false) {
				dfsRecursive(adjList, it, visited, dfs);
			}
		}
	}

}
