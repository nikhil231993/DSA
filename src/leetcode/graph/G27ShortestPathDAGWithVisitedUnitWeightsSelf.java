package leetcode.graph;

import java.util.*;

public class G27ShortestPathDAGWithVisitedUnitWeightsSelf {

	public static void main(String[] args) {
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

		dist[src]=0;
		visited[src]=1;
		Queue<Integer> q=new LinkedList<>();
		q.offer(src);

		while(!q.isEmpty()){
			Integer node=q.poll();

			for(Integer vertex:adjlist.get(node)){
				if(visited[vertex]==0){
					visited[vertex]=1;
					dist[vertex]=1+dist[node];
					q.offer(vertex);
				}
			}
		}

		return dist;

	}
}
