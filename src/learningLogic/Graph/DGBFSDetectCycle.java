package learningLogic.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DGBFSDetectCycle {

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
		for (int i = 0; i <= n; i++) {
			for (Integer num : adjList.get(i)) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		System.out.println("BFS Traversal of DisConnected Nodes Graph: ");
//		ArrayList<Integer> resultDisconnected = dfsTraversalDisConnectedNodes(adjList, n);
//		for (Integer num : resultDisconnected) {
//			System.out.println(num + " ");
//		}

		System.out.println("Is Cycle present in BFS : " + bfsDetectCycle(adjList, n));

		scan.close();

	}

	private static boolean bfsDetectCycle(ArrayList<ArrayList<Integer>> adjList, int n) {
		ArrayList<Integer> topoSort = new ArrayList<Integer>();
		int[] indegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for(Integer num:adjList.get(i)) {
				indegree[num]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			Integer num = q.poll();
			topoSort.add(num);
			for (Integer vertices : adjList.get(num)) {
				indegree[vertices]--;
				if (indegree[vertices] == 0) {
					q.add(vertices);
				}
			}

		}

		if (topoSort.size() == n) {
			return false;
		}

		return true;
	}



}
