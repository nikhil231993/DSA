package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class G18BipartiteDFS {

    public static void main(String[] args) {

        List<List<Integer>> arr=new ArrayList<>();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter no of Vertex: ");
        int n=scan.nextInt();
        System.out.println("Enter no of Edges: ");
        int m=scan.nextInt();

        adjacencyList(arr,n,m,scan);

        System.out.println(bipartitedfs(arr,n,m));
    }

    private static boolean bipartitedfs(List<List<Integer>> arr, int n, int m) {

        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        //considering nodes start with index=1
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(bipartite(i,n,m,color,arr)==false){
                    return false;
                }
            }
        }
        return true;

        //TC:O(N)for loop + O(N+2E) dfs
        //SC:O(N) color arr + O(N) stack
    }

    private static boolean bipartite(int i, int n, int m, int[] color, List<List<Integer>> arr) {

        for(Integer vertex: arr.get(i)){
            if(color[vertex]==-1){
                color[vertex]=1-color[i];
                if(bipartite(vertex,n,m,color,arr)==false){
                    return false;
                }
            }else if(color[vertex]==color[i]){
                return false;
            }
        }
        return true;
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
