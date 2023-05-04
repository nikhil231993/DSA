package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G26AlienDictionary {

    public static void main(String[] args) {
        String[] words=new String[]{"baa","abcd","abca","cab","cad"};
        int n=words.length;
        int k=5;
        String s=alienDictionary(words,n,k);
        System.out.println(s);
    }

    private static String alienDictionary(String[] words, int n, int k) {

        List<List<Integer>> adList=new ArrayList<>();

        for(int i=0;i<k;i++)
            adList.add(new ArrayList<>());

        for(int i=0;i<words.length-1;i++){
            String firstString=words[i];
            String secondString=words[i+1];
            for(int j=0;j<Math.min(firstString.length(),secondString.length());j++){
                if(firstString.charAt(j)!=secondString.charAt(j)){
                    adList.get(firstString.charAt(j)-'a').add(secondString.charAt(j)-'a');
                    break;
                }
            }
        }

        List<Integer> list=topoSort(adList,k);

        String s="";
        for(int i=0;i<list.size();i++){
            s+=(char)(list.get(i)+(int)'a');
        }
        return s;

    }
    private static List<Integer> topoSort(List<List<Integer>> arr, int n) {

        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(Integer v:arr.get(i)){
                indegree[v]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            Integer node=q.poll();
            list.add(node);
            for(Integer vertex:arr.get(node)){
                indegree[vertex]--;
                if(indegree[vertex]==0){
                    q.offer(vertex);
                }
            }
        }
        return list;

        //SC:O(N) queue+O(N) indegree +O(N)toposort
        //TC:O(N+E)
    }
}
