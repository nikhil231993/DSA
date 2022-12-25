package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DGDFSDetectCycle {

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

		System.out.println("Detect cycle in a DFS Directed Graph: ");
		System.out.println(dfsCycleDetectionInDirectedGraph(adjList, n));


//		System.out.println("Detect cycle in a DFS Directed Graph Using Stack: ");
//		System.out.println(dfsCycleDetectionInUndirectedGraphUsingStack(adjList, n));
		scan.close();

	}

//	private static boolean dfsCycleDetectionInUndirectedGraphUsingStack(ArrayList<ArrayList<Integer>> adjList, int n) {
//		boolean visited[] = new boolean[n + 1];
//		boolean dfsVisited[] = new boolean[n + 1];
//		for (int i = 1; i <= n; i++) {
//			if (visited[i] == false)
//				visited[i] = true;
//			dfsVisited[i] = true;
//			Stack<Integer> s = new Stack<>();
//			s.push(i);
//			while (!s.isEmpty()) {
//				Integer num = s.pop();
//				visited[num] = true;
//				dfsVisited[num] = true;
//				for (Integer it : adjList.get(num)) {
//					if (visited[it] == false) {
//						s.push(it);
//					} else if (dfsVisited[it] == true && dfsVisited[num] == true) {
//						return true;
//					}
//				}
//				dfsVisited[num] = false;
//			}
//		}
//		return false;
//	}




	private static boolean dfsCycleDetectionInDirectedGraph(ArrayList<ArrayList<Integer>> adjList, int n) {
		boolean[] visited = new boolean[n + 1];
		boolean[] dfsVisited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				if (detectCycle(adjList, i, visited, dfsVisited))
					return true;
			}
		}
		return false;
	}

	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited,
			boolean[] dfsVisited) {
		visited[i] = true;
		dfsVisited[i] = true;
		for(Integer vertices:adjList.get(i)) {
			if(visited[vertices]==false) {
				if(detectCycle(adjList, vertices, visited, dfsVisited))
					return true;
			} else if (dfsVisited[vertices] == true)
				return true;

		}
		dfsVisited[i] = false;
		return false;

	}

	private static ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {

		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				dfsRecursive(visited, dfs, adjList, i);
			}
		}

		return dfs;
	}

	private static void dfsRecursive(boolean[] visited, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adjList,
			int i) {
		visited[i] = true;
		dfs.add(i);
		for(Integer vertices:adjList.get(i)) {
			if(visited[vertices]==false) {
				dfsRecursive(visited, dfs, adjList, vertices);
			
			}
		}
	}

}
