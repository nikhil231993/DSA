package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G19DetectCycleDirectedGraphDFS {

    public static void main(String[] args) {

        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        adjacencyList(arr,n,m,scan);

        System.out.println(detectCycle(arr,n,m));
    }

    private static boolean detectCycle(List<List<Integer>> arr, int n, int m) {
        
        int[] visited=new int[n+1];
        int[] pathVisited=new int[n+1];
        
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                if(cycle(arr,n,m,visited,pathVisited,i))
                    return true;
            }
        }
        return false;
    }

    private static boolean cycle(List<List<Integer>> arr, int n, int m, int[] visited, int[] pathVisited,int i) {

        visited[i]=1;
        pathVisited[i]=1;
        for(Integer vertex:arr.get(i)){
            if(visited[vertex] == 0) {
                if (cycle(arr, n, m, visited, pathVisited, vertex))
                    return true;
            }else if(pathVisited[vertex] == 1)
                return true;
        }
        pathVisited[i]=0;
        return false;

        //TC: O(N) + O(N+E)
        //SC: O(2N) we can also do it with one visited array
        //Hint: Take visited as 1 and pathVisited as 2
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
