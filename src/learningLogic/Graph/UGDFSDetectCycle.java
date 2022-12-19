package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UGDFSDetectCycle {

	class Node {
		int first;
		int second;

		Node(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		UGDFSDetectCycle detectCycleInUG = new UGDFSDetectCycle();
		detectCycleInUG.createGraph();

	}

	private void createGraph() {
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

		System.out.println("Detect cycle in a DFS undirected Graph: ");
		System.out.println(dfsCycleDetectionInUndirectedGraph(adjList, n));
		scan.close();

		System.out.println("Detect cycle in a DFS undirected Graph Using Stack: ");
		System.out.println(dfsCycleDetectionInUndirectedGraphUsingStack(adjList, n));
		scan.close();

	}

	private boolean dfsCycleDetectionInUndirectedGraphUsingStack(ArrayList<ArrayList<Integer>> adjList, int n) {

		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				visited[i] = true;

				Stack<Node> st = new Stack<Node>();
				st.add(new Node(i, -1));

				while (!st.isEmpty()) {
					int first = st.peek().first;
					int second = st.peek().second;
					st.pop();
					for (Integer vertices : adjList.get(first)) {
						if (visited[vertices] == false) {
							visited[vertices] = true;
							st.push(new Node (vertices,first));
						} else if (vertices != second) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean dfsCycleDetectionInUndirectedGraph(ArrayList<ArrayList<Integer>> adjList, int n) {
		boolean[] visited = new boolean[n + 1];
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) {
				if (detectCycleRecursive(adjList, i, -1, visited))
					return true;
			}
		}
		return false;

	}

	private boolean detectCycleRecursive(ArrayList<ArrayList<Integer>> adjList, int i, int parent, boolean[] visited) {
		visited[i]=true;
		for(Integer vertices:adjList.get(i)) {
			if(visited[vertices]==false) {
				if (detectCycleRecursive(adjList, vertices, i, visited) == true)
					return true;
			} else if (vertices != parent) {
				return true;
				
			}
		}
		return false;
	}

	private ArrayList<Integer> dfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean[] visited=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) {
				recursive(adjList, i, dfs, visited);
			}
		}
		return dfs;
	}

	private void recursive(ArrayList<ArrayList<Integer>> adjList, int i, ArrayList<Integer> dfs, boolean visited[]) {
		dfs.add(i);
		visited[i] = true;
		for (Integer vertices : adjList.get(i)) {
			if (visited[vertices] == false) {
				recursive(adjList, vertices, dfs, visited);
			}
		}
	}

}
