package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;


public class MinimumSpanningTree {

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

		for (int j = 0; j < n - 1; j++) {
			int min_value = Integer.MAX_VALUE;
			int min_index=-1;
			for(int i=0;i<n;i++) {
				if (mst[i] == false && key[i] < min_value) {
					min_index = i;
					min_value = key[i];

				}
			}
			
			mst[min_index] = true;

			for (Node num : adjList.get(min_index)) {
				if (mst[num.v] == false && num.weight < key[num.v]) {
					key[num.v] = num.weight;
					parent[num.v] = min_index;
				}
			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " - " + i);
		}

	}

}
