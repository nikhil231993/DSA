package revision.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSBipartite {

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

		System.out.println("BFS Traversal of DisConnected Nodes Graph: ");
		ArrayList<Integer> resultDisconnected = bfsTraversalDisConnectedNodes(adjList, n);
		for (Integer num : resultDisconnected) {
			System.out.println(num + " ");
		}

		System.out.println("Detect cycle in a BFS undirected Graph: ");
		System.out.println(bfsBipartite(adjList, n));
		scan.close();

	}

	private static boolean bfsBipartite(ArrayList<ArrayList<Integer>> adjList, int n) {

		int[] colour = new int[n + 1];
		Arrays.fill(colour, -1);
		for (int i = 1; i <= n; i++) {
			if (colour[i] == -1) {
				colour[i] = 1;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);
				while (!q.isEmpty()) {
					Integer num = q.poll();
					for (Integer it : adjList.get(num)) {
						if (colour[it] == -1) {
							colour[it] = 1 - colour[num];
							q.add(it);
						} else {
							if (colour[it] == colour[num])
								return false;
						}
					}
				}
			}
		}
		return true;

	}

	private static ArrayList<Integer> bfsTraversalDisConnectedNodes(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		boolean visited[] = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				Queue<Integer> q = new LinkedList<>();
				q.add(i);

				while (!q.isEmpty()) {
					Integer num = q.poll();
					bfs.add(num);
					for (Integer it : adjList.get(num)) {
						if (visited[it] == false) {
							visited[it] = true;
							q.add(it);
						}
					}
				}

			}

		}
		return bfs;
	}

}
