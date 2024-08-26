package leetcode.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class G3UnweightedGraph {

    public static void main(String[] args) {

        adjacencyMatrix();
        adjacencyList();
    }

    private static void adjacencyList() {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        System.out.println("Creating " +n +" List:");
        for(int i=0;i<=n;i++)
            arr.add(new ArrayList<>());

        System.out.println("Enter the edges values: ");
        for(int i=1;i<=m;i++){
            System.out.println("Enter the "+ i +" edge: ");
            int u=scan.nextInt();
            int v=scan.nextInt();
            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        System.out.println("Adjacency List is: ");

        int i=0;
        for(List<Integer> l: arr){
            System.out.print("List: "+ i++);
            System.out.println(l);
        }

        //SC:O(2*Edges) This is tp only show space complexity
    }

    private static void adjacencyMatrix() {

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        System.out.println("Enter the edges values: ");
        int[] [] arr = new int[n+1][n+1];

        for(int i=1;i<=m;i++){
            System.out.println("Enter the "+ i +" edge: ");
            int u=scan.nextInt();
            int v=scan.nextInt();
            arr[u][v]=1;
            arr[v][u]=1;
        }

        System.out.println("Matrix is: ");
        for(int i=0;i<=n;i++){
          for(int j=0;j<=n;j++){
              System.out.print(arr[i][j]);
          }
          System.out.println();
        }

        //SC:O(n*n) This is tp only show space complexity
    }
}
