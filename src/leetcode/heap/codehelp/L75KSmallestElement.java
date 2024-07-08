package leetcode.heap.codehelp;

import java.util.PriorityQueue;

public class L75KSmallestElement {

    public static void main(String[] args) {

        int[] arr=new int[]{7,10,4,20,15,1,0};
        int k=4;

        //Approach 1: Sort the array and return arr[k-1] TC:O(nlogn)

        //Approach 2:
        System.out.println(KSmallest(arr,k));

        //Approach 3: Same as above but we insert in PQ only if value is smaller than the top element in
        System.out.println(KSmallestOptimized(arr,k));
    }

    private static int KSmallestOptimized(int[] arr, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<k;i++){
            pq.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.peek();

        //max heap
        //TC:o(O(K + (n-k)*log(k)))
        //The time complexity of this method is O(K + (n-k)*log(k)). Because we are building a max heap of k elements
        //and then checking the remaining (n-k) elements into the top of the heap.
        //SC:O(k)
    }

    private static int KSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(Integer num:arr){
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();

        //TC:o(Nlogk)
        //SC:O(k)
    }
}
