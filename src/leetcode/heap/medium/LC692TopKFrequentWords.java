package leetcode.heap.medium;

import java.util.*;

class NodeString{

    protected int freq;
    protected String value;

    public NodeString(int freq, String value){
        this.freq=freq;
        this.value=value;
    }
}

class NodeStr {

    protected int count;
    protected String str;

    public NodeStr(int count, String str) {
        this.count = count;
        this.str = str;
    }
}

public class LC692TopKFrequentWords {

    public static void main(String[] args) {

        String[] words =new String[] {"the","day","is","sunny","the","the","the","sunny","is","is","is"};
        int k = 3;

        //Approach 1:
        System.out.println(topKFrequent(words,k));

        //Approach 2:
        System.out.println(topKFrequentOptimised(words,k));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map=new HashMap();
        for(String num:words){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<NodeString> pq=new PriorityQueue<>((a,b)->a.freq==b.freq?b.value.compareTo(a.value):a.freq-b.freq);
        for(Map.Entry<String, Integer> m: map.entrySet()){
            pq.offer(new NodeString(m.getValue(), m.getKey()));
            if(pq.size()>k)
                pq.poll();
        }

        PriorityQueue<NodeString> pq1=new PriorityQueue<>((a,b)->a.freq==b.freq?a.value.compareTo(b.value):b.freq-a.freq);
        while(!pq.isEmpty()){
            String s=pq.peek().value;
            int freq=pq.peek().freq;
            pq.poll();
            pq1.offer(new NodeString(freq, s));
        }

        List<String> result=new ArrayList();
        while(!pq1.isEmpty()){
            result.add(pq1.poll().value);
        }

        return result;

        //TC:O(n)+o(nlog k)
        //SC:O(k)
    }

    public static List<String> topKFrequentOptimised(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<NodeStr> pq = new PriorityQueue<>((a,b) -> a.count == b.count ? b.str.compareTo(a.str) : a.count-b.count);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new NodeStr(entry.getValue(), entry.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        } // O(n log k)

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().str);
        }

        Collections.reverse(ans); //O(k log k)
        return ans;

        //TC: O(n log k) + O(k log k)
        //SC: O(2*k)
    }
}
