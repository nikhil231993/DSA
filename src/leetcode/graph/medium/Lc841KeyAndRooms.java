package leetcode.graph.medium;

import java.util.*;

public class Lc841KeyAndRooms {

    public static void main(String[] args) {
        //  rooms = [[1],[2],[3],[]]
        List<List<Integer>> keys=new ArrayList<>();
        keys.add(Arrays.asList(1));
        keys.add(Arrays.asList(2));
        keys.add(Arrays.asList(3));
        keys.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(keys));

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> q=new LinkedList();
        q.add(0);
        int n=rooms.size();
        int[] visited=new int[n];
        while(!q.isEmpty()){
            Integer node=q.poll();

            if(visited[node]==1)
                continue;
            visited[node]=1;

            for(Integer vertex:rooms.get(node)){
                if(visited[vertex]==0){
                    q.offer(vertex);
                }
            }
        }

        for(int i=1;i<n;i++){
            if(visited[i]==0)
                return false;
        }
        return true;

    }
}
