package leetcode.heap.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC767ReorganizeStringImportant {

    public static void main(String[] args) {

        String s ="aab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {

        HashMap<Character, Integer> counts=new HashMap<>();

        for(Character c : s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue((a, b)-> counts.get(b) - counts.get(a));
        pq.addAll(counts.keySet());

        StringBuilder sb=new StringBuilder();

        while(pq.size()>1){

            Character current=pq.poll();
            Character next=pq.poll();

            sb.append(current);
            sb.append(next);

            counts.put(current, counts.get(current)-1);
            counts.put(next, counts.get(next)-1);

            if(counts.get(current)>0)
                pq.offer(current);

            if(counts.get(next)>0)
                pq.offer(next);
        }

        if(!pq.isEmpty()){
            Character last=pq.poll();
            if(counts.get(last)>1)
                return "";
            else
                sb.append(last);
        }
        return sb.toString();

        // TC:O(n log n)
        // SC:O(n) worst case
    }
}
