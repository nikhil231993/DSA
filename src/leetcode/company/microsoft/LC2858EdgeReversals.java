package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

class Node {
    int node;
    int cost;
    public Node(int node, int cost){
        this.node=node;
        this.cost=cost;
    }
}

public class LC2858EdgeReversals{

    public static void main(String[] args) {
        int n = 4;
        int[] []edges =new int[][] {{2,0},{2,1},{1,3}};
        int[] result=minEdgeReversals(n, edges);
        for(int num:result)
            System.out.println(num);
    }

    public static int[] minEdgeReversals(int n, int[][] edges) {

        List<List<Node>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Node>());
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new Node(edges[i][1], 0));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], 1));
        }

        int[] ans=new int[n];
        ans[0]=calculateZeroNodeCost(adjList, n, 0, -1);
        calculateOtherNodesFromZeroNode(ans, adjList, 0, -1);
        return ans;
    }

    private static void calculateOtherNodesFromZeroNode(int[] ans, List<List<Node>> adjList, int node, int parent){
        for(Node child:adjList.get(node)){
            if(child.node==parent)
                continue;
            if(child.cost==0){
                ans[child.node]=ans[node]+1;
            }else{
                ans[child.node]=ans[node]-1;
            }
            calculateOtherNodesFromZeroNode(ans, adjList, child.node, node);
        }
    }

    private static int calculateZeroNodeCost(List<List<Node>> adjList, int n, int node, int parent){
        int cost=0;
        for(Node child:adjList.get(node)){
            if(child.node==parent)
                continue;
            cost=cost+child.cost;
            cost=cost+calculateZeroNodeCost(adjList, n, child.node, node);
        }
        return cost;
    }
}
