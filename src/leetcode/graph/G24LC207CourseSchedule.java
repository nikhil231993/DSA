package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G24LC207CourseSchedule {

    public static void main(String[] args) {

        //Can be done using dfs or bfs. Use toposort to detect cycle.
        //We are using toposort with bfs as next question is based on that

        int[][] prerequisites=new int[][]{{1,0},{0,1}};
        int numCourses=2;
        System.out.println(canFinish(numCourses,prerequisites));

        //TC:O(N) + O(N+E)
        //SC:O(N) queue + O(N) Indegree
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> list=new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree=new int[numCourses];
        for(int i=0; i<list.size(); i++){
            for(Integer n : list.get(i)){
                indegree[n]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> topoSort=new ArrayList<>();
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
        return topoSort.size()==numCourses;
    }
}
