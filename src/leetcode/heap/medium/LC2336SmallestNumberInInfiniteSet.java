package leetcode.heap.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq=new PriorityQueue<>();
    private Set<Integer> set=new HashSet();

    public SmallestInfiniteSet() {

        for(int i=1;i<=1000;i++){
            pq.offer(i);
            set.add(i);
        }
    }

    public int popSmallest() {

        set.remove(pq.peek());
        return pq.poll();
    }

    public void addBack(int num) {

        if(!set.contains(num)){
            set.add(num);
            pq.offer(num);
        }
    }
}

public class LC2336SmallestNumberInInfiniteSet {

    public static void main(String[] args) {

        SmallestInfiniteSet obj = new SmallestInfiniteSet();

        int param_1 = obj.popSmallest();
        obj.addBack(1);
        System.out.println(param_1);
    }
}
