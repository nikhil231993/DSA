package leetcode.heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class NodeCharacter {

    protected int freq;
    protected Character value;

    public NodeCharacter(int freq, Character value){
        this.freq=freq;
        this.value=value;
    }
}

public class LC451SortCharacterByFrequency {

    public static void main(String[] args) {

        String s = "Aabb";

        //Approach 1:
        System.out.println(frequencySort(s));

        //Approach 2: Since for s = "tree" both "eert" and "eetr" are correct so we do need to compare the character which has same freq and thus lexicography check can be avoided
        System.out.println(frequencySortOptimised(s));
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<NodeCharacter> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.value.compareTo(a.value) : a.freq - b.freq);
            for(Map.Entry<Character, Integer> m:map.entrySet()) {
               pq.offer(new NodeCharacter(m.getValue(), m.getKey()));
        }

        PriorityQueue<NodeCharacter> pq1 = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.value.compareTo(b.value) : b.freq - a.freq);
        while(!pq.isEmpty()){
            Character s1 = pq.peek().value;
            int freq = pq.peek().freq;
            pq.poll();
            pq1.offer(new NodeCharacter(freq, s1));
        }

        String s2 = "";
        while(!pq1.isEmpty()) {

            int num = pq1.peek().freq;
            Character c = pq1.peek().value;
            pq1.poll();
            StringBuilder sb = new StringBuilder();

            for (int i=0;i<num;i++)
                sb.append(c);
            s2 += sb.toString();
        }
            return s2;

        //TC:o(n)
        //SC:O(n)
    }

    public static String frequencySortOptimised(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        PriorityQueue<NodeCharacter> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new NodeCharacter(entry.getValue(), entry.getKey()));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            NodeCharacter pair = pq.poll();
            for (int i =0; i<pair.freq; i++) {
                sb.append(pair.value);
            }
        }
        return sb.toString();
    }
}
