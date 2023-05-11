package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class PairG43 {
	int dist;
	int node;

	public PairG43(int node, int dist) {
		this.node = node;
		this.dist = dist;

	}
}
public class G43SmallestDistanceNeighbours {

	public static void main(String[] args) {
		
		
// 		example 1
		int n = 4;
		int[][] edges = new int[][] { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		int distanceThreshold = 4;

//		 example 2
//		int[][] edges = new int[][] { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
//		int n = 5;
//		int distanceThreshold = 2;

		System.out.println(cityWithSmallestDistanceUsingDijkstra(n, edges, distanceThreshold));
		System.out.println(cityWithSmallestDistance(n, edges, distanceThreshold));



	}

	private static int cityWithSmallestDistanceUsingDijkstra(int n, int[][] edges, int distanceThreshold) {
		
		

		int[][] costMatrix = new int[n][n];
		
		// Creating Adjacency List:
		List<List<PairG43>> adjList=new ArrayList<List<PairG43>>();
		for(int i=0;i<n;i++) {
			adjList.add(new ArrayList<PairG43>());
		}
		
		for(int i=0;i<n;i++) {
			adjList.get(edges[i][0]).add(new PairG43(edges[i][1], edges[i][2]));
			adjList.get(edges[i][1]).add(new PairG43(edges[i][0], edges[i][2]));	
		}
		
		// In Dijkstra we have to just find the shortest distance between for all the
		// nodes in a loop i.e., the only difference
		for (int i = 0; i < n; i++) {
			int[] distanceNode=new int[n];
			Arrays.fill(distanceNode, (int)(1e9));
			PriorityQueue<PairG43> pq = new PriorityQueue<PairG43>((a, b) -> a.dist - b.dist);
			pq.add(new PairG43( i,0));
			distanceNode[i] = 0;
			
			while(!pq.isEmpty()) {
				int distance=pq.peek().dist;
				int node=pq.peek().node;
				pq.poll();
				
				for(PairG43 vertex:adjList.get(node)) {
					int v=vertex.node;
					int edW=vertex.dist;
					if (distanceNode[v] > distance + edW) {
						distanceNode[v] = distance + edW;
						pq.offer(new PairG43(v, distanceNode[v]));

					}
				}
				
			}
			costMatrix[i] = distanceNode;
		}

//		System.out.println("Costing Matriz:");
//
//		for (int[] m : distList) {
//			System.out.println(m[0] + "  " + m[1] + "  " + m[2] + "  " + m[3]);
//			System.out.println();
//		}

		int count = Integer.MAX_VALUE;
		int maxCity = Integer.MAX_VALUE;

		for (int city = 0; city < n; city++) {
			int cnt = 0;
			for (int adCity = 0; adCity < n; adCity++) {
				if (costMatrix[city][adCity] <= distanceThreshold) {
					cnt++;
				}
			}
			if (cnt <= count) {
				maxCity = city;
				count = cnt;
			}
		}

		return maxCity;
	}

	private static int cityWithSmallestDistance(int n, int[][] edges, int distanceThreshold) {
		
		int[][] costMatrix=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				costMatrix[i][j]=(int)(1e9);
				if(i==j) {
					costMatrix[i][j]=0;
				}
				
			}
		}
		
		for(int i=0;i<edges.length;i++) {
			int u=edges[i][0];
			int v=edges[i][1];
			int wt=edges[i][2];
			
			costMatrix[u][v] = wt;
			costMatrix[v][u] = wt;
		}
//		
//		System.out.println("Print the matrix:");
//
//		for (int[] m : costMatrix) {
//			System.out.println(m[0] + "  " + m[1] + "  " + m[2] + "  " + m[3]);
//			System.out.println();
//		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					costMatrix[i][j] = Math.min(costMatrix[i][j], costMatrix[i][k] + costMatrix[k][j]);
				}
			}
		}
//
//		System.out.println("After costing:");
//
//		for (int[] m : costMatrix) {
//			System.out.println(m[0] + "  " + m[1] + "  " + m[2] + "  " + m[3]);
//			System.out.println();
//		}
		
		int count=Integer.MAX_VALUE;
		int maxCity=Integer.MAX_VALUE;
		
		for(int city=0;city<n;city++) {
			int cnt = 0;
			for(int adCity=0;adCity<n;adCity++) {
				if(costMatrix[city][adCity]<=distanceThreshold) {
					cnt++;
				}
			}
			if (cnt <= count) {
				maxCity = city;
				count = cnt;
			}
		}

		return maxCity;

		// Time Complexity: O(V3), as we have three nested loops each running for V
		// times,
		// where V = no. of vertices.

		// Space Complexity: O(V2), where V = no. of vertices. This space complexity is
		// due to storing the
		// adjacency matrix of the given graph.
	}

}
