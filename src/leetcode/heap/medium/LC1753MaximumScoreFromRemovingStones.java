package leetcode.heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1753MaximumScoreFromRemovingStones {
	
	public static void main(String[] args) {

		int a = 10, b = 15, c = 20;
		System.out.println(maximumScore(a, b, c));
        System.out.println(maximumScoreSelf(a, b, c));
	}
	
    private static int maximumScore(int a, int b, int c) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a1,b1) -> b1 - a1);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        
        int count=0;
        while(pq.size()>1){
            int n1=pq.poll();
            int n2=pq.poll();
            n1--;
            n2--;
            if(n1>0)
                pq.offer(n1);
            if(n2>0)
                pq.offer(n2);
            count++;
        }
        return count;

        //TC:O(3 log 3)
        //SC:O(3
    }

    private static int maximumScoreSelf(int a, int b, int c) {
        // 1. Sort the array so that array[0] <= array[1] <= array[2]
        int[] piles = {a, b, c};
        Arrays.sort(piles);

        int x = piles[0]; // smallest
        int y = piles[1]; // middle
        int z = piles[2]; // largest

        // 2. Apply the mathematical logic
        if (x + y <= z) {
            // Case 1: The largest pile absorbs both smaller piles completely
            return x + y;
        } else {
            // Case 2: The piles are balanced, we can consume almost all stones
            return (x + y + z) / 2;
        }
    }
}
