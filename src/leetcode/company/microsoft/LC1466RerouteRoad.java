package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class LC1466RerouteRoad {

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(minReorder(n, connections));
    }

    private static int minReorder(int n, int[][] connections) {
        List<List<Node>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Node>());
        for(int i=0;i<connections.length;i++){
            adjList.get(connections[i][0]).add(new Node(connections[i][1], 1));
            adjList.get(connections[i][1]).add(new Node(connections[i][0], 0));
        }

        int count=dfs(adjList, 0, -1);
        return count;
    }

    private static int dfs(List<List<Node>> adjList, int node, int parent){
        int cost=0;
        for(Node child: adjList.get(node)){
            if(child.node!=parent){
                cost+=child.cost+dfs(adjList, child.node, node);
            }
        }
        return cost;
    }
}
