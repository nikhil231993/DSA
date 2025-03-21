package leetcode.heap.codehelp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L76KthLargestSumContiguousSubarray {

    public static void main(String[] args) {

        int N = 3;
        int K = 2;
        int[] Arr =new int[] {3,2,1};

        //Approach 1: Brute force
        System.out.println(kthLargest(N,K,Arr));

        //Approach 2: Using Heap
        System.out.println(kthLargestUsingHeap(N,K,Arr));
    }

    private static int kthLargestUsingHeap(int N, int K, int[] Arr) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int sum=0;
            for(int j=i; j<N; j++){

                sum+=Arr[j];
                pq.offer(sum);
                if(pq.size()>K)
                    pq.poll();
            }
        }
        //O(k)
        return pq.peek();

        //TC:O(n square * log k) This is because all the combinations of subarray is n(n+1)/2
        //SC:O(k)
    }

    public static int kthLargest(int N, int K, int[] Arr) {

        int size=N*(N+1)/2;
        int[] arr=new int[size];

        int k=0;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum += Arr[j];
                arr[k++]=sum;
            }
        }
        //O(n square)
        Arrays.sort(arr);//(n square log n square)

        return arr[size-K];

        //TC:O(n square log n square)
        //SC:O(n square)
    }
}
