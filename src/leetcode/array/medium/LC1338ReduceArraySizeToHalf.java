package leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node{
    int key;
    int count;
    public Node(int key, int value){
        this.key=key;
        this.count=value;
    }
}
public class LC1338ReduceArraySizeToHalf {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Node> pq =new PriorityQueue<>((a, b)->(b.count-a.count));
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            pq.offer(new Node(m.getKey(), m.getValue()));
        }

        int n=arr.length;
        int m=n;
        int count=0;
        while(m>n/2){
            int c=pq.poll().count;
            m=m-c;
            count++;
        }
        return count;
    }

}
