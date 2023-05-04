package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G24LC210CourseSchedule2 {

    public static void main(String[] args) {
        int[][] prerequisites=new int[][]{{0,1}};
        int numCourses=2;

        //can we done using dfs or bfs  toposort to detect cycle. we are using toposort as next question is based on that
       int[] result= isPossible(numCourses,prerequisites);
       for(Integer n:result)
           System.out.println(n);
        //TC:O(N)+O(N+E)
        //SC:O(N) queue + O(N) indegree
    }
    public static int[] isPossible(int numCourses, int[][] prerequisites) {

        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree=new int[numCourses];
        for(int i=0;i<list.size();i++){
            for(Integer n:list.get(i)){
                indegree[n]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> topoSort=new ArrayList();
        while(!q.isEmpty()){
            Integer node=q.poll();
            topoSort.add(node);

            for(Integer vertex: list.get(node)){
                indegree[vertex]--;
                if(indegree[vertex]==0){
                    q.offer(vertex);
                }
            }


        }
        int[] arr=new int[topoSort.size()];
        if(topoSort.size()==numCourses)
        {
            for(int i=0;i<list.size();i++){
                arr[i]=topoSort.get(i);
            }
            return arr;
        }
        else
            return new int[]{};

    }
}
