package leetcode.graph;

import java.util.*;

public class G12DetectCycleDFS {

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

        System.out.println(detectCycleDfs(arr,n,m));

 //       Not working
//        System.out.println(detectCycleInMatrix(matrix,n,m));

    }

    private static boolean detectCycleInMatrix(int[][] matrix, int n, int m) {

        int[] visited=new int[n+1];
        for(int i=0;i<=n;i++){
            if(visited[i]==0){
                if(detect(i,matrix,n,m,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detect(int i, int[][] matrix, int n, int m,int parent,int[] visited) {

            for (int j = 0; j <= n; j++) {
                if (visited[j]==0 &&  matrix[i][j] == 1) {
                    visited[j]=1;
                  if(detect(j,matrix,n,m,i,visited)){
                      return true;
                  }
                } else if (j != parent && matrix[i][j]==1)
                    return true;
            }
        return false;
    }


    private static boolean detectCycleDfs(List<List<Integer>> arr, int n, int m) {
        int[] visited=new int[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                if(cycle(i,arr,n,m,visited,-1)){
                    return true;
                }
            }
        }
        //SC:o(n) visited + o(n) auxiliary space worst case
        //TC:O(N+2e)+O(n)
        return false;
    }

    private static boolean cycle(int i, List<List<Integer>> arr, int n, int m,int[] visited,int parent) {

        visited[i]=1;
        for(Integer vertex: arr.get(i)){
            if(visited[vertex]==0){
                if(cycle(vertex,arr,n,m,visited,i)){
                    return true;
                }
            }else if(vertex!=parent){
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
}
