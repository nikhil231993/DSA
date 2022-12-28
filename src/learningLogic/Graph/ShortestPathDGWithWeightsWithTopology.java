package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


class Node {
	int v;
	int weight;

	Node(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

}

public class ShortestPathDGWithWeightsWithTopology {



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
		
		Stack<Integer> s = new Stack<Integer>();

		int[] path = new int[n + 1];
		Arrays.fill(path, Integer.MAX_VALUE);
		boolean[] visited=new boolean[n+1];
		
		for(int i=0;i<=n;i++) {
			if (visited[i] == false) {
				recursiveTopo(s, visited, adjList, i);
			}
		}
		path[src] = 0;

		while (!s.isEmpty()) {
			int node = s.pop();

			if (path[node] != Integer.MAX_VALUE) {
				for (Node vertices : adjList.get(node)) {
					if (path[node] + vertices.weight < path[vertices.v]) {
						path[vertices.v] = path[node] + vertices.weight;
					}
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

	private static void recursiveTopo(Stack<Integer> s, boolean[] visited, ArrayList<ArrayList<Node>> adjList, int i) {
		visited[i] = true;
		for (Node vertices : adjList.get(i)) {
			if (visited[vertices.v] == false) {
				recursiveTopo(s, visited, adjList, vertices.v);
			}
		}
		s.push(i);

	}

}
