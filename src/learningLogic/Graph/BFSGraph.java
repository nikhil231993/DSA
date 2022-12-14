package learningLogic.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraph {

	public void createGraph() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of vertices:  i.e n: ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges: i.e m: ");
		int m = scan.nextInt();

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 1; i <= n + 1; i++)
			arr.add(new ArrayList<Integer>());

		System.out.println("Enter the edges: ");
		for (int i = 1; i <= m; i++) {
			System.out.println("Enter the " + i + " edge: ");
			int u = scan.nextInt();
			int v = scan.nextInt();

			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		ArrayList<Integer> response = bfs(arr, n, m);
		for (Integer num : response) {
			System.out.println(num + " ");
		}
		printGraph(arr, n);
		scan.close();
	}

	private ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> arr, int n, int m) {

		boolean[] visited = new boolean[n + 1];

		ArrayList<Integer> bfs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					Integer num = q.poll();
					bfs.add(num);
					for (Integer vertices : arr.get(num)) {
						if (visited[vertices] == false) {
							q.add(vertices);
							visited[vertices] = true;

						}
					}
				}

			}
		}
		return bfs;
	}

	private void printGraph(ArrayList<ArrayList<Integer>> arr, int n) {
		for(int i=1;i<=n;i++) {
			System.out.print(i + " --> ");
			for (Integer num : arr.get(i)) {
				System.out.print(num + " " );
			}
			System.out.println();
		}


	}


}
