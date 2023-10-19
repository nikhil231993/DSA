package leetcode.heap.easy;

import java.util.PriorityQueue;

public class LC2558RichPile {

    public static void main(String[] args) {
        int[] gifts =new int[] {25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts,k));
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
    }
}
