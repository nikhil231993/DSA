package leetcode.graph;

import java.util.*;

public class G23DetectCycleUsingTopoSortBFS {

    public static void main(String[] args) {
        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

        adjacencyList(arr,n,m,scan);

        System.out.println("Detect Cycle");

        System.out.println(topoSort(arr,n,m));
    }

    private static boolean topoSort(List<List<Integer>> arr, int n, int m) {

        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(Integer v:arr.get(i)){
                indegree[v]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            Integer node=q.poll();
            list.add(node);
            for(Integer vertex:arr.get(node)){
                indegree[vertex]--;
                if(indegree[vertex]==0){
                    q.offer(vertex);
                }
            }
        }
        return list.size()<n;
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
