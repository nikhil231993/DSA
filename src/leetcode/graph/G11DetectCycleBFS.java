package leetcode.graph;

import java.util.*;

class PairParent{
    int node;
    int parent;

    public PairParent(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}
public class G11DetectCycleBFS {

    public static void main(String[] args) {
        System.out.println("#################List Creation Start#####################");
        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();
        adjacencyList(arr,n,m,scan);

        //Adjacency Matrix
        int[][] matrix=new int[n+1][n+1];
        adjacencyMatrix(matrix,n,m,scan);
        System.out.println("################List Creation End#####################");

        System.out.println(detectCycle(arr,n,m));

        System.out.println(detectCycleInMatrix(matrix,n,m));

    }

    private static boolean detectCycleInMatrix(int[][] matrix, int n, int m) {

        int[] visited=new int[n+1];
        for(int i=0;i<=n;i++){
                if(visited[i]==0){
                    if(detect(i,matrix,n,m,visited)){
                        return true;
                    }
                }
        }
        return false;
    }

    private static boolean detect(int i, int[][] matrix, int n, int m, int[] visited) {
//        visited[i]=1;
        Queue<PairParent> q=new LinkedList<>();
        q.add(new PairParent(i,-1));
        while (!q.isEmpty()){
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();

            for(int j=0;i<=n;j++){
                if(visited[j]==0 && matrix[node][j]==1){
                    visited[j]=1;
                    q.offer(new PairParent(j,node));
                }else if(j!=parent)
                    return true;
            }
        }
        return false;
    }

    private static void adjacencyMatrix(int[][] matrix, int n, int m, Scanner scan) {

            System.out.println("Enter the edges values: ");
            for(int i=1;i<=m;i++){
                System.out.println("Enter the "+ i +" edge: ");
                int u=scan.nextInt();
                int v=scan.nextInt();
                matrix[u][v]=1;
                matrix[v][u]=1;

            }

            System.out.println("Adjacency Matrix List is: ");

         for(int i=0;i<=n;i++){
             for(int j=0;j<=n;j++){
                 System.out.print(matrix[i][j]);
             }
             System.out.println();
         }




    }

    private static boolean detectCycle(List<List<Integer>> arr, int n, int m) {

        Queue<PairParent> q=new LinkedList<>();
        int[] visited=new int[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]==0) {
                if (cycle(visited, q, n, m, arr, i))
                    return true;
            }
        }

        //tc:o(n+2e)
        //sc:o(n) queue+O(n) visited array
        return false;
    }

    private static boolean cycle(int[] visited, Queue<PairParent> q, int n, int m, List<List<Integer>> arr,int i) {
        q.add(new PairParent(i,-1));
        visited[i]=1;
        while(!q.isEmpty()){

            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();

            for(Integer vertex:arr.get(node)){
                if(visited[vertex]==0){
                    q.offer(new PairParent(vertex,node));
                    visited[vertex]=1;
                }else if(parent!=vertex)
                    return true;
            }

        }
        return false;

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
