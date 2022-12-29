package learningLogic.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class MSTUsingPrimsAlgoUsingPQ {

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

		System.out.println("Minimum Spanning tree is : ");
		minimumSpanningTree(adjList, n);

		scan.close();

	}

	private static void minimumSpanningTree(ArrayList<ArrayList<Node>> adjList, int n) {
		int[] key = new int[n];
		boolean[] mst = new boolean[n];
		int[] parent = new int[n];

		for (int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
			parent[i] = -1;
		}

		// take minimum value as starting node
		key[0] = 0;
		PriorityQueue<NodeVertex> pq = new PriorityQueue<NodeVertex>(n, new NodeVertex());
		pq.add(new NodeVertex(0, key[0]));

		for (int j = 0; j < n - 1; j++) {
			NodeVertex min_node = pq.poll();
			
			mst[min_node.v] = true;

			for (Node num : adjList.get(min_node.v)) {
				if (mst[num.v] == false && num.weight < key[num.v]) {
					key[num.v] = num.weight;
					parent[num.v] = min_node.v;
					pq.add(new NodeVertex(num.v, key[num.v]));
				}
			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " - " + i);
		}

	}

}
