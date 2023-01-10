package learningLogic.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Node3 implements Comparator<Node3> {
	int u;
	int v;
	int w;

	public Node3(int u,int v,int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public Node3() {

	}

	@Override
	public int compare(Node3 o1, Node3 o2) {
		if (o1.w < o2.w)
			return -1;
		else if (o1.w < o2.w)
			return 1;

		return 0;
	}
}

public class MSTUsingKruskalAlgorithm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of nodes : ");
		int n = scan.nextInt();
		System.out.println("Enter the no of edges : ");
		int m = scan.nextInt();
		ArrayList<Node3> arr = new ArrayList<Node3>();
		
		for(int i = 1;i<=m;i++) {
			System.out.println("Enter the "+i +" edge");
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			arr.add(new Node3(u, v, w));

		}

		Collections.sort(arr, new Node3());
		
		int[] parent = new int[n + 1];
		int[] rank = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int costMst=0;
		
		ArrayList<Node3> mst=new ArrayList<Node3>();
		for(Node3 it:arr) {
			if (findPar(it.u, parent) != findPar(it.v, parent)) {
				costMst += it.w;
				mst.add(it);
				union(it.u, it.v, rank, parent);
			}
		}

		System.out.println("Cost is : " + costMst);
		for (Node3 it : mst) {
			System.out.println(it.u + " " + it.v);
		}

		System.out.println("All parents are : ");
		for (int i = 1; i <= n; i++) {
			System.out.println("parent of : " + i + " = " + parent[i]);
		}

		scan.close();
	}

	private static int findPar(int node, int[] parent) {
		if (node == parent[node])
			return node;
		return parent[node] = findPar(parent[node], parent);
	}

	private static void union(int u, int v, int[] rank, int[] parent) {
		int pU = findPar(u, parent);
		int pV = findPar(v, parent);
		if (rank[pU] < rank[pV]) {
			parent[pU] = pV;
		} else if (rank[pU] > rank[pV]) {
			parent[pV] = pU;
		} else {
			parent[pV] = pU;
			rank[pU]++;
		}

	}

}
