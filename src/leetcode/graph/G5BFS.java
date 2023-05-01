package leetcode.graph;

import java.util.*;

public class G5BFS {

    public static void main(String[] args) {
        System.out.println("#################List Creation Start#####################");
        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();
        adjacencyList(arr,n,m,scan);
        System.out.println("################List Creation End#####################");

        bfs(arr,n,m);
    }

    private static void bfs(List<List<Integer>> arr,int n, int m) {

        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        boolean[] visited=new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i]=true;
                q.add(i);

                while(!q.isEmpty()){
                    Integer vertex=q.poll();
                    bfs.add(vertex);
                    for(Integer v: arr.get(vertex)){
                        if(!visited[v])
                        {
                            q.add(v);
                            visited[v]=true;
                        }
                    }

                }
            }
        }

        System.out.println("BFS is: ");
        System.out.println(bfs);

        //SC:O(3N) for queue, bfs list and visited array (not using adjacency list as it is given)
        //TC:O(N) for while loop + O(2E) as the for loop inside it runs for all the degrees of the node
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
