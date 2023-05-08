package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class G21TopoSortDFS {

    public static void main(String[] args) {
        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        adjacencyList(arr,n,m,scan);

        System.out.println("TopoSort");

        int[] visited=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                topoSort(arr,n,m,visited,s,i);
            }
        }
      List<Integer> l=new ArrayList<>();
        while(!s.isEmpty()){
            l.add(s.pop());
        }
        System.out.println(l);
    }

    private static void topoSort(List<List<Integer>> arr, int n, int m, int[] visited, Stack<Integer> s,int i) {

        visited[i]=1;
        for(Integer vertex: arr.get(i)){
            if(visited[vertex]==0)
                topoSort(arr,n,m,visited,s,vertex);
        }
        s.push(i);

        //TC:O(N)+O(N+E)
        //SC:0(N) visited array +O(N) recursion stack
    }


    private static void adjacencyList(List<List<Integer>> arr,int n, int m, Scanner scan) {
        System.out.println("Creating " +n +" List:");
        for(int i=0;i<=n;i++)
            arr.add(new ArrayList<>());

        System.out.println("Enter the edges values: ");
        for(int i=1;i<=m;i++){
            System.out.println("Enter the "+ i +" edge: ");
            int u=scan.nextInt();
            int v=scan.nextInt();
            arr.get(u).add(v);


        }

        System.out.println("Adjacency List is: ");

        int i=0;
        for(List<Integer> l: arr){
            System.out.print("List: "+ i++);
            System.out.println(l);
        }
        //SC:O(2*Edges)
    }
}
