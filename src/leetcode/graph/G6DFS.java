package leetcode.graph;

import java.util.*;

public class G6DFS {

    public static void main(String[] args) {
        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        adjacencyList(arr,n,m,scan);

        dfs(arr,n,m);
    }

    private static void dfs(List<List<Integer>> arr, int n, int m) {

        boolean[] visited=new boolean[n+1];
        ArrayList<Integer> dfs=new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(!visited[i])
            {
                dfsRecursive(arr,dfs,visited,i);
            }
        }

        System.out.println("DFS traversal is: ");
        System.out.println(dfs);
    }

    private static void dfsRecursive(List<List<Integer>> arr, ArrayList<Integer> dfs,boolean[] visited, int i) {

        visited[i]=true;
        dfs.add(i);
        for(Integer vertex: arr.get(i)){
            if(!visited[vertex]){
                visited[vertex]=true;
                dfsRecursive(arr,dfs,visited,vertex);
            }
        }
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
            arr.get(v).add(u);

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