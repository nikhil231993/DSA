package leetcode.heap.medium;

import java.util.*;
class NodeString{
    int freq;
    String value;

    public NodeString(int freq, String value){
        this.freq=freq;
        this.value=value;
    }
}
public class LC692TopKFrequentWords {

    public static void main(String[] args) {
        String[] words =new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        System.out.println(topKFrequent(words,k));
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
}
