package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G55LC1192BridgesInGraph {

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        System.out.println(criticalConnections(n, connections));
    }

    private static List<List<Integer>> criticalConnections(int n, int[][] connections) {

        //Step 1: convert graph to adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //Step 2: dfs traversal staring from node 0
        int[] visited = new int[n];
        //only the insertion time
        int[] tin = new int[n];
        //low among node and child which is not parent
        int[] low = new int[n];

        List<List<Integer>> ans = new ArrayList<>();
        dfs(visited, 0, -1, tin, low, adjList, ans);//Assuming its single component we start from 0
        return ans;

    }

    public static int timeOfInsertion = 1;

    private static void dfs(int[] visited, int node, int parent, int[] tin, int[] low, List<List<Integer>> adjList, List<List<Integer>> ans) {

        visited[node] = 1;
        tin[node] = timeOfInsertion;
        low[node] = timeOfInsertion;
        timeOfInsertion++;
        for (Integer vertex : adjList.get(node)) {
            if (vertex == parent)
                continue;//as we dont need to get low from parent as it will be same
            if (visited[vertex] == 0) {
                dfs(visited, vertex, node, tin, low, adjList, ans);
                low[node] = Math.min(low[node], low[vertex]);
                if (tin[node] < low[vertex]) {
                    ans.add(new ArrayList<>(Arrays.asList(node, vertex)));
                }
            } else {
                low[node] = Math.min(low[node], low[vertex]);
            }
        }

        // Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a simple DFS traversal.

        // Space Complexity: O(V+2E) + O(3V), where V = no. of vertices, E = no. of edges. O(V+2E) to store the graph in an adjacency list and O(3V) for the three arrays i.e. tin, low, and vis, each of size V.    }
    }
}
