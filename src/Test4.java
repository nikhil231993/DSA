import java.util.*;


class Node11{

    String s;
    int freq;

    public Node11(String s, int freq){
        this.s=s;
        this.freq=freq;
    }
}

public class Test4 {

    public static void main(String[] args) {

        String[] arr = {"apple", "apple", "apple", "banana", "banana", "orange"};
        int k = 2;
        System.out.println(findKthMostFrequent(arr, k));
    }

    private static String findKthMostFrequent(String[] arr, int k) {

        HashMap<String, Integer> map=new HashMap<>();
        for(String str : arr)
            map.put(str, map.getOrDefault(str, 0)+1);

        PriorityQueue<Node11> pq=new PriorityQueue<>((a,b)->a.freq-b.freq);
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            pq.offer(new Node11(m.getKey(), m.getValue()));
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek().s;
    }
}
