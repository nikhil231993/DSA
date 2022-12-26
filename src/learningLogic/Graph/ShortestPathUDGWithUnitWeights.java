package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class ShortestPathUDGWithUnitWeights {

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

		System.out.println("Enter the source : ");
		int src = scan.nextInt();

		System.out.println("Enter the destination : ");
		int dest = scan.nextInt();

		System.out.println("Enter the destination : ");

		System.out.println("Shortest Path : ");
		shortestPath(adjList, n, src, dest);
		scan.close();

	}

	private static void shortestPath(ArrayList<ArrayList<Integer>> adjList, int n, int src, int dest) {

		int[] path = new int[n + 1];
		Arrays.fill(path, Integer.MAX_VALUE);
		
		path[src] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);

		while (!q.isEmpty()) {
			Integer num = q.poll();
			for (Integer vertices : adjList.get(num)) {
				if (path[num] + 1 < path[vertices]) {
					path[vertices] = path[num] + 1;
					q.add(vertices);
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
