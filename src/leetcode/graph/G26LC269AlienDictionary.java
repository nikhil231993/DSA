package leetcode.graph;

import java.util.*;

public class G26LC269AlienDictionary {

    public static void main(String[] args) {

        String[] words =new String[] {"wrt","wrf","er","ett","rftt"};
        words=new String[]{"z", "z"};
        words=new String[]{"abc", "ab"};
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {

        int n = words.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }
        Set<Integer> set = new HashSet<>();

        // Add all unique characters to the set
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c - 'a');
            }
        }

        // Build the graph
        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Edge case: if word1 is longer and a prefix of word2, return ""
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Perform topological sort
        List<Integer> topo = toposort(adjList, set);
        if (topo.size() != set.size()) {
            return ""; // Cycle detected or incomplete topological sort
        }

        StringBuilder sb = new StringBuilder();
        for (int i : topo) {
            sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }

    public static List<Integer> toposort(List<List<Integer>> adjList, Set<Integer> set) {

        int[] indegree = new int[26];
        for (int i = 0; i < adjList.size(); i++) {
            for (int vertex : adjList.get(i)) {
                indegree[vertex]++;
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        for (int i : set) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            list.add(node);
            for (int vertex : adjList.get(node)) {
                indegree[vertex]--;
                if (indegree[vertex] == 0) {
                    pq.offer(vertex);
                }
            }
        }
        return list;
    }
}
