package leetcode.math.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC1492KthFactor {

    public static void main(String[] args) {

        int n=12,k=3;

        //Approach 1
        System.out.println(kthFactor(n,k));

        //Approach 2
        System.out.println(kthFactorBetter(n,k));

        //Approach 3
        System.out.println(kthFactorHeap(n,k));

        //Approach 4
        System.out.println(kthFactorBest(n,k));
    }

    public static int kthFactorBetter(int n, int k) {

        int count =0;
        for (int i =1;i<=n;i++) {
            if (n%i == 0 && ++count == k) {
                return i;
            }
        }
        return -1;
    }

    public static int kthFactor(int n, int k) {

        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0)
                list.add(i);
        }
        if(list.size()<k)
            return -1;
        return list.get(k-1);
    }

    public static int kthFactorHeap(int n, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)-> b - a );

        for(int i=1;i<=n; i++){
            if(n%i==0)
                pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.size()<k?-1:pq.peek();
    }

    public static int kthFactorBest(int n, int k) {

        for(int i = 1; i < Math.sqrt(n); i ++) {
            if(n%i==0)
                k--;
            if(k==0)
                return i;
        }

        for(int i = (int)Math.sqrt(n); i >= 1; -- i){
            if(n%i==0)
                k--;
            if(k==0)
                return n/i;

        }
        return - 1;
    }
}
