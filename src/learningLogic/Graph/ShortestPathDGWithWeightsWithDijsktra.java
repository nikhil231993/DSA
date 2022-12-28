package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class ShortestPathDGWithWeightsWithDijsktra {

	public static void main(String[] args) {
		createGraph();

	}

	private static void createGraph() {
		Scanner scan = new Scanner(System.in);
		ArrayList<ArrayList<NodeVertex>> adjList = new ArrayList<ArrayList<NodeVertex>>();
		System.out.println("Enter the no of vertices: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges: ");
		int m = scan.nextInt();
		System.out.println("Creating ArrayLIst of ArrayList: ");
		for (int i = 0; i <= n; i++)
			adjList.add(new ArrayList<>());
		System.out.println("Enter the combination of edges pair: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			System.out.println("Enter the weight of the edge: ");
			int w = scan.nextInt();
			adjList.get(u).add(new NodeVertex(v, w));
		}

		System.out.println("Enter the source : ");
		int src = scan.nextInt();

		System.out.println("Enter the destination : ");
		int dest = scan.nextInt();

		System.out.println("BFS Traversal of DisConnected Nodes Graph: ");

		System.out.println("Shortes Path : ");
		shortestPath(adjList, n, src, dest);

		scan.close();

	}

	private static void shortestPath(ArrayList<ArrayList<NodeVertex>> adjList, int n, int src, int dest) {

		int[] path = new int[n + 1];
		Arrays.fill(path, Integer.MAX_VALUE);

		PriorityQueue<NodeVertex> pq = new PriorityQueue<NodeVertex>(n, new NodeVertex());
		pq.add(new NodeVertex(src, 0));

		path[src] = 0;

		while (!pq.isEmpty()) {
			NodeVertex nodeVertex = pq.poll();

			for (NodeVertex vertex : adjList.get(nodeVertex.v)) {
				if (path[nodeVertex.v] + vertex.w < path[vertex.v]) {
					path[vertex.v] = path[nodeVertex.v] + vertex.w;
					pq.add(new NodeVertex(vertex.v, path[vertex.v]));
				}
			}
		}
		int i = 0;
		for (int num : path) {
			System.out.println(i + "-->" + num + " ");
			if (dest == i)
				System.out.println("Shortest distance from src : + " + src + " to dest : " + dest + " is : " + num);
			i++;
		}
	}

}
