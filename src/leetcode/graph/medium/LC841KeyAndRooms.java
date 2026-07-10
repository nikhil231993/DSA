package leetcode.graph.medium;

import java.util.*;

public class LC841KeyAndRooms {

    public static void main(String[] args) {
        //  rooms = [[1],[2],[3],[]]
        List<List<Integer>> keys=new ArrayList<>();
        keys.add(Arrays.asList(1));
        keys.add(Arrays.asList(2));
        keys.add(Arrays.asList(3));
        keys.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(keys));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {

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

    public boolean canVisitAllRoomsApproach2(List<List<Integer>> rooms) {
            int n=rooms.size();
            int[] visited=new int[n];
            Queue<Integer> q=new LinkedList<>();
            q.offer(0);
            visited[0]=1;

            while(!q.isEmpty()){
                Integer no=q.poll();
                for(Integer vertex:rooms.get(no)){
                    if(visited[vertex]==0){
                        q.offer(vertex);
                        visited[vertex]=1;
                    }
                }
            }
            for(int i=0;i<n;i++)
                if(visited[i]==0)
                    return false;
            return true;
        }

}
