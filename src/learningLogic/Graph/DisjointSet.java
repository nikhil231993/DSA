package learningLogic.Graph;

import java.util.Scanner;

public class DisjointSet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of nodes : ");
		int n = scan.nextInt();
		int[] parent = new int[n + 1];
		int[] rank = new int[n + 1];
		makeSet(parent, n, rank);

		System.out.println("Enter the operations : ");
		int noOfOperation = scan.nextInt();
		for (int i = 1; i <= noOfOperation; i++) {
			System.out.println("Enter the " + i + " operation: ");
			int u = scan.nextInt();
			int v = scan.nextInt();
			union(u, v, rank, parent);
		}

		System.out.println("Enter the nodes to find the pair :");
		int first = scan.nextInt();
		int second = scan.nextInt();

		int firstParent = findPar(first, parent);
		int secondParent = findPar(second, parent);
		if (firstParent == secondParent) {
			System.out.println("Same component");
		} else {
			System.out.println("Different component");
		}
		System.out.println("All parents are : ");
		for (int i = 1; i <= n; i++) {
			System.out.println("parent of : " + i + " = " + parent[i]);
		}

		scan.close();
	}

	private static int findPar(int node,int[] parent) {
		if(node==parent[node])
			return node;
		return parent[node] = findPar(parent[node], parent);
	}

	private static void union(int u, int v,int[] rank, int[] parent) {
		int pU = findPar(u, parent);
		int pV = findPar(v, parent);
		if (rank[pU] < rank[pV]) {
			parent[pU] = pV;
		} else if (rank[pU] > rank[pV]) {
			parent[pV] = pU;
		} else {
			parent[pV] = pU;
			rank[pV]++;
		}

	}

	private static void makeSet(int[] parent, int n, int[] rank) {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

	}

}
