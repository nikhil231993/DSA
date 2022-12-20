package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BipartiteDFS {

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
		scan.close();

	}

	private static boolean dfsBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {
		int[] color = new int[n + 1];
		Arrays.fill(color, -1);
		for (int i = 1; i <= n; i++) {
			if (color[i] == -1) {
				color[i] = 1;
				if (!isBipartite(color, i, adjList)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isBipartite(int[] color, int i, ArrayList<ArrayList<Integer>> adjList) {
		for(Integer vertices:adjList.get(i)) {
			if(color[vertices]==-1) {
				color[vertices]=1-color[i];
				if (!isBipartite(color, vertices, adjList))
					return false;
			}else if(color[vertices]==color[i])
				return false;
		}
		return true;
	}

	private static ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false)
				recursiveDfs(dfs, visited, i, adjList);
		}
		return dfs;
	}

	private static ArrayList<Integer> recursiveDfs(ArrayList<Integer> dfs, boolean[] visited, int i,
			ArrayList<ArrayList<Integer>> adjList) {
		visited[i] = true;
		dfs.add(i);
		for (Integer vertices : adjList.get(i)) {
			if (visited[vertices] == false)
				recursiveDfs(dfs, visited, vertices, adjList);
		}
		return dfs;

	}

}
