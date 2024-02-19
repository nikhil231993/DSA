package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC1753MaximumScoreFromRemovingStones {
	
	public static void main(String[] args) {

		int a = 2, b = 4, c = 6;
		System.out.println(maximumScore(a, b, c));
	}
	
    public static int maximumScore(int a, int b, int c) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a1,b1)->b1-a1);
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        
        int count=0;
        while(pq.size()>1){
            Integer n1=pq.poll();
            Integer n2=pq.poll();
            n1=n1-1;
            n2=n2-1;
            count++;
            if(n1>0)
                pq.offer(n1);
            if(n2>0)
                pq.offer(n2);
            
        }
        return count;

        //TC:O(3 log 3)
        //SC:O(3
    }
}
