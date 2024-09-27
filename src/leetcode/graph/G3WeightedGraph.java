package leetcode.graph;

import java.util.ArrayList;
import java.util.Scanner;

class Node {

    protected int v;
    protected int w;

    protected Node(int v, int w){
        this.v=v;
        this.w=w;
    }
}

public class G3WeightedGraph {

    public static void main(String[] args) {

        adjacencyMatrix();
        adjacencyList();
    }

    private static void adjacencyList() {

        Scanner scan=new Scanner(System.in);

        System.out.println("Enter no of edges: ");
        int n=scan.nextInt();

        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        ArrayList<ArrayList<Node>> arr=new ArrayList<>();
        System.out.println("Creating " +n +" List:");
        for(int i=0;i<=n;i++)
            arr.add(new ArrayList<>());

        System.out.println("Enter the edges values: ");

        for(int i=1;i<=m;i++){

            System.out.println("Enter the "+ i +" edge: ");
            int u=scan.nextInt();
            int v=scan.nextInt();
            System.out.println("Weight: ");
            int w=scan.nextInt();
            arr.get(u).add(new Node(v,w));
            arr.get(v).add(new Node(u,w));
        }

        System.out.println("Adjacency List is: ");

        int i=0;
        for(ArrayList<Node> l: arr){

            System.out.print("Lists "+ i++ +" is: ");
            System.out.println();
            System.out.print("[");
            for(Node node:l){
              System.out.print("("+node.v+","+ node.w+")");
            }
            System.out.println("]");
            System.out.println();
        }

        //SC:O(2*Edges)
    }

    private static void adjacencyMatrix() {

        Scanner scan=new Scanner(System.in);

        System.out.println("Enter no of edges: ");
        int n=scan.nextInt();

        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        System.out.println("Enter the edges values: ");

        int[] [] arr=new int[n+1][n+1];
        for(int i=1;i<=m;i++){

            System.out.println("Enter the "+ i +" edge: ");
            int u=scan.nextInt();
            int v=scan.nextInt();
            System.out.println("Weight: ");
            int w=scan.nextInt();
            arr[u][v]=w;
            arr[v][u]=w;
        }

        System.out.println("Matrix is: ");
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
               System.out.print(arr[i][j]);
            }
          System.out.println();
        }

        //SC:O(n*n)
    }
}
