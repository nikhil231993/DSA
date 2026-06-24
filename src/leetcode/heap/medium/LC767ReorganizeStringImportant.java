package leetcode.heap.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC767ReorganizeStringImportant {

    public static void main(String[] args) {

        String s ="aab";
        System.out.println(reorganizeString(s));

        //Optimised approach
        System.out.println(reorganizeStringSelf(s));
    }

    public static String reorganizeString(String s) {

        HashMap<Character, Integer> counts=new HashMap<>();

        for(Character c : s.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue((a, b)-> counts.get(b)-counts.get(a));
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

        //TC:O(n log n)
        //SC:O(n) worst case
    }

    private static String reorganizeStringSelf(String s) {

        var charCounts = new int[26];
        int maxCount = 0, letter = 0;
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
            if (charCounts[c - 'a'] > maxCount) {
                maxCount = charCounts[c - 'a'];
                letter = c - 'a';
            }
        }

        if (maxCount > (s.length()+1) / 2) {
            return "";
        }
        var ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}
