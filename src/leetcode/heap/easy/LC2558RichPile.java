package leetcode.heap.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC2558RichPile {

    public static void main(String[] args) {

        int[] gifts =new int[] {25,64,9,4,100};
        int k = 4;

        //Brute Force 1:
        System.out.println(pickGiftsBrute(gifts, k));

        //Optimal
        System.out.println(pickGifts(gifts,k));
    }

    public static long pickGiftsBrute(int[] gifts, int k) {

        int n = gifts.length;

        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            // Initialize the index of the richest pile (maximum element)
            int richestPileIndex = 0;

            // Iterate through the array to find the index of the maximum element
            for (int currentPileIndex = 0; currentPileIndex < n; currentPileIndex++) {
                // If we find a new maximum, update the index
                if (gifts[richestPileIndex] < gifts[currentPileIndex]) {
                    richestPileIndex = currentPileIndex;
                }
            }

            // Replace the richest pile with the floor of its square root
            gifts[richestPileIndex] = (int) Math.floor(Math.sqrt(gifts[richestPileIndex]));
        }

        // Calculate the sum of the remaining gifts in the array
        long numberOfRemainingGifts = Arrays.stream(gifts).mapToLong(gift -> gift) // Map to long to avoid overflow
                .sum();

        return numberOfRemainingGifts;

        //TC:O(k*n)
        //SC:O(1)
    }

    public static long pickGifts(int[] gifts, int k) {

        PriorityQueue<Long> pq=new PriorityQueue<>((a, b)->Long.compare(b,a));
        for(int i=0;i<gifts.length;i++)
            pq.offer((long)(gifts[i]));

        while(k!=0){
            long num=pq.poll();
            long newNum=(long)Math.sqrt(num);
            pq.offer(newNum);
            k--;
        }
        
        long sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;

        //TC:O(n log n)
        //SC:O(n)
    }
}
