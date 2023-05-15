package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G26AlienDictionary {

    public static void main(String[] args) {
//        String[] words=new String[]{"wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"};
        String[] words=new String[]{"baa",
                "abcd",
                "abca",
                "cab",
               "cad"};
        int n=words.length;
        int k=26;//Try with 5
        //int k=26;
        //Above k is used if we are given random digits order and the first 4-5 digits
        //If the value of k is 6 then it will be befdac where e can come at any place
        //If it is not in initial order then we can find entire
        //alphabets toposort and then find only characters we need https://leetcode.com/discuss/interview-question/248131/Microsoft-Interview-(round-1)-Alien-Dictionary
        String s=alienDictionary(words,n,k);
        System.out.println(s);

        //Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary,
        // ‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
        //
        //Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array,
        // and O(K) for the queue data structure used in BFS(where K = no.of nodes),
        // O(K) for the answer array and O(K) for the adjacency list used in the algorithm.
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
