package leetcode.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class G54StronglyConnectedComponents {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter no of vertex: ");
        int V=scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        adjacencyList(V,scan,adjList);

        System.out.println(noOfConnectedComponents(V,adjList));
    }

    private static int noOfConnectedComponents(int v, ArrayList<ArrayList<Integer>> adjList) {
        //Step 1: Find the finishing time that is which the last basically toposort
        //so that we know where to start at
        Stack<Integer> st=new Stack<>();
        int[] visited=new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==0)
                dfs(st,v,adjList,visited,i);
        }
        //Step 2: Reverse the edges so that we can count the SCC later

        ArrayList<ArrayList<Integer>> reverseAdjList=new ArrayList<>();
        for(int i=0;i<v;i++){
            reverseAdjList.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(Integer adjNode: adjList.get(i)){
                reverseAdjList.get(adjNode).add(i);
            }
        }

        //Step 3: Start parsing through stack by taking each element out of it

        int[] newVisited=new int[v];
        int count=0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (newVisited[node] == 0) {
                count++;
                dfsReverse(newVisited, node, reverseAdjList);
            }
        }
        return count;
        //TC:O(N)+O(N+E) dfs + O(N)+O(N+E) transposing +O(N)+O(N+E) dfs
        //Space Complexity: O(V)+O(V)+O(V+E), where V = no. of vertices, E = no. of edges. Two O(V) for the visited array and the stack we have used. O(V+E) space for the reversed adjacent list.
    }
    public static void dfsReverse(int[] visited, int node,ArrayList<ArrayList<Integer>> reverseAdjList){
        visited[node]=1;
        for(Integer adjNode:reverseAdjList.get(node)){
            if(visited[adjNode]==0){
                dfsReverse(visited,adjNode,reverseAdjList);
            }
        }
    }


    private static void dfs(Stack<Integer> st, int v, ArrayList<ArrayList<Integer>> adjList,int[] visited,int node) {
        visited[node]=1;
        for(Integer vertex:adjList.get(node)){
            if(visited[vertex]==0){
                dfs(st,v,adjList,visited,vertex);
            }
        }
        st.push(node);
    }

    private static void adjacencyList(int n,Scanner scan,ArrayList<ArrayList<Integer>> arr) {


        System.out.println("Enter no of edges: ");
        int m=scan.nextInt();

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
        for(ArrayList<Integer> l: arr){
            System.out.print("List: "+ i++);
            System.out.println(l);
        }
        //SC:O(2*Edges)
    }
}
