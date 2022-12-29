package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Scanner;

class NodeBF {
	int u;
	int v;
	int w;

	public NodeBF(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}


}
public class BellmanFordAlgorithm {



	public static void main(String[] args) {
		createGraph();

	}

	private static void createGraph() {
		Scanner scan = new Scanner(System.in);
		ArrayList<NodeBF> adjList = new ArrayList<NodeBF>();
		System.out.println("Enter the no of vertices: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges: ");
		int m = scan.nextInt();

		System.out.println("Enter the combination of edges pair: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			System.out.println("Enter the weight of the edge: ");
			int w = scan.nextInt();
			adjList.add(new NodeBF(u, v, w));
		}

		System.out.println("Enter the source : ");
		int src = scan.nextInt();

		System.out.println("Shortes Path : ");
		shortestPathoRCycle(adjList, n, src);

		scan.close();

	}

	private static void shortestPathoRCycle(ArrayList<NodeBF> adjList, int n, int src) {
		int[] dist = new int[n];
//		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < n; ++i)
			dist[i] = 10000000;

		dist[src]=0;
		
		for (int i = 1; i <= n - 1; i++) {
			for (NodeBF vertices : adjList) {
				if (dist[vertices.u] + vertices.w < dist[vertices.v]) {
					dist[vertices.v] = dist[vertices.u] + vertices.w;
				}
			}
		}

		int fl = 0;
		for (NodeBF vertices : adjList) {
			if (dist[vertices.u] + vertices.w < dist[vertices.v]) {
					System.out.println("Negative cycle detcted");
					fl = 1;
					break;
				}
		}
		if (fl == 0) {
			for (int i = 0; i < n; i++)
				System.out.println(i + " " + dist[i]);
		}

	}


}
