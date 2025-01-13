package leetcode.heap.medium;

import java.util.PriorityQueue;

class SeatManager {

    private PriorityQueue<Integer> pq=new PriorityQueue();

    public SeatManager(int n) {

        for(int i=1; i<=n; i++)
            pq.offer(i);
    }

    public int reserve() {

        return pq.poll();
    }

    public void unreserve(int seatNumber) {

        pq.offer(seatNumber);
    }
}

public class LC1845SeatManager {

    public static void main(String[] args) {

         SeatManager obj = new SeatManager(5);

         int param_1 = obj.reserve();
         obj.unreserve(6);
         System.out.println(param_1);
    }
}
