package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathUDGWithWeightsWithoutDijsktra {

	public static void main(String[] args) {
		createGraph();

	}

	private static void createGraph() {
		Scanner scan = new Scanner(System.in);
		ArrayList<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>();
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
			adjList.get(u).add(new Node(v, w));
			adjList.get(v).add(new Node(u, w));
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

	private static void shortestPath(ArrayList<ArrayList<Node>> adjList, int n, int src, int dest) {

		int[] path = new int[n + 1];
		Arrays.fill(path, Integer.MAX_VALUE);
		
		path[src] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);

		while (!q.isEmpty()) {
			Integer num = q.poll();
			for (Node vertices : adjList.get(num)) {
				if (path[num] + vertices.weight < path[vertices.v]) {
					path[vertices.v] = vertices.weight;
					q.add(vertices.v);
				}
			}
		}
		int i = 0;
		for (int num : path) {
			System.out.println(i + "-->" + num + " ");
			if(dest==i)
				System.out.println("Shortest distance from src : + " + src + " to dest : " + dest + " is : " + num);
			i++;
		}

	}

}
