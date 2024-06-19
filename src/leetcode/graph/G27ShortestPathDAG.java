package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class PairG27 {

	protected int node;
	protected int weight;

	public PairG27(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}

public class G27ShortestPathDAG {

		//IMP:Why toposort works?
		//1.we go from one node to another node in an order which guarantees that previous node is processed and has shortest distance
		//Dijkstra(ElogV) will also work to find shortest distance, but it takes more time than toposort(V+E)
		//2.Dijkstra algo is necessary for graphs which contains cycles because they can't be topologically sorted.
		//3.Toposort works with negative weights in a DAG

	public static void main(String[] args) {

		// Below is with weights
		int[][] edge = new int[][] { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 },
				{ 5, 3, 1 } };
		//int[][] edge = new int[][] { { 6, 4, 2 }, { 4, 0, 3 }, { 0, 1, 2 }, { 1, 3, 1 }, { 6, 5, 3 }, { 5, 4, 1 },
		//{ 4, 2, 1 }, { 2, 3, 1 } };
		// Below is with unit weights
		//int[][] edge = new int[][] { { 0, 1, 1 }, { 0, 4, 1 }, { 4, 5, 1 }, { 4, 2, 1 }, { 1, 2, 1 }, { 2, 3, 1 },
		//{ 5, 3, 1 } };

		int V = 6;
		int E = 7;
		int src = 2;//we can take any node as source and it will work as for not reachable nodes it will give 1e9

		// Convert matrix to adjList;
		
		List<List<PairG27>> adjList=new ArrayList();
		
		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<PairG27>());
		}
		
		for (int[] r: edge) {
				adjList.get(r[0]).add(new PairG27(r[1], r[2]));
		}

		// Toposort
		int[] visited = new int[V];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<V;i++) {
			if (visited[i] == 0) {
				dfsTopo(adjList, V, E, st, visited, i);
			}
		}

		int[] dist = new int[V];
		Arrays.fill(dist, (int) (1e9));

		shortestDistance(dist, adjList, V, E, src, st);

		// Shortest distance are
		for (Integer n : dist)
			System.out.println(n);

		// Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation
		// of vertices, each node and its adjacent nodes get traversed} ~ O(N+M).
		// Where N= number of vertices and M= number of edges.
		// Space Complexity: O( N) {for the stack storing the topological sort} + O(N) {for storing the
		// shortest distance for each node} + O(N) {for the visited array} + O( N+2M)
		// {for the adjacency list} ~ O(N+M) .
		// Where N= number of vertices and M= number of edges.
	}

	private static void shortestDistance(int[] dist, List<List<PairG27>> adjList, int v, int e, int src,Stack<Integer> st) {

		dist[src]=0;
		while (!st.isEmpty()) {
			Integer node = st.pop();

			for (PairG27 vertex : adjList.get(node)) {
				if (dist[vertex.node] > dist[node] + vertex.weight) {
					dist[vertex.node] = dist[node] + vertex.weight;
				}
			}
		}

		// to set distance to -1 for which we cannot calculate
		for (int i = 0; i < v; i++) {
			if (dist[i] == 1e9)
				dist[i] = -1;
		}
	}

	private static void dfsTopo(List<List<PairG27>> adjList, int V, int E, Stack<Integer> st, int[] visited, int i) {

		visited[i] = 1;
		for (PairG27 vertex : adjList.get(i)) {
			if (visited[vertex.node] == 0) {
				dfsTopo(adjList, V, E, st, visited, vertex.node);
			}
		}
		st.push(i);
	}
}
