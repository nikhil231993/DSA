package leetcode.graph;

import java.util.*;

public class G27ShortestPathDAGWithVisitedUnitWeightsSelfBFS {

	public static void main(String[] args) {

		//Below is with normal BFS with visited array, and it works because if we reach a node first time
		//it will be the shortest path with unit weights
		//but if the weight varies then we cannot use normal BFS with visited array
		//but if we remove visited array then it will work only in case of graphs without negative weights. (Note: This statement might be wrong which says it will not work with negative weights)
		//If negative weights are there and directed graph then it will work
		//If negative weights are there with UG then it will not work

		int V = 9, E = 10;
		int[][] edges = new int[][]{{0, 1}, {0, 3}, {3, 4}, {4, 5}
				, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
		int src = 0;

		//Creating Adjacency List
		List<List<Integer>> adjlist = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adjlist.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			adjlist.get(edges[i][0]).add(edges[i][1]);
		}

		//Below is using 2.
		int[] result = shortestPath(adjlist, V, E, src);
		System.out.println("####################");
		for (Integer n : result)
			System.out.println(n);
	}

	private static int[] shortestPath(List<List<Integer>> adjlist,int V, int E,int src) {

		int[] visited=new int[V];
		int[] dist=new int[V];

		Arrays.fill(dist,(int)(1e9));

		dist[src]=0;
		visited[src]=1;
		Queue<Integer> q=new LinkedList<>();
		q.offer(src);

		while(!q.isEmpty()){
			Integer node=q.poll();

			for(Integer vertex : adjlist.get(node)){
				if(visited[vertex] == 0){
					visited[vertex] = 1;
					dist[vertex] = 1 + dist[node];
					q.offer(vertex);
				}
			}
		}
		return dist;

		//Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’}
		// + O(N + 2M) { for the BFS Algorithm} + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).
		//Where N= number of vertices and M= number of edges.

		//Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array}
		// + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
		//Where N= number of vertices and M= number of edges.
	}
}
