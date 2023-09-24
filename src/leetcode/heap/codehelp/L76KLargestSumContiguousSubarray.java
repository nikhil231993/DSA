package leetcode.heap.codehelp;

import java.util.Arrays;
import java.util.PriorityQueue;
public class L76KLargestSumContiguousSubarray {
    public static void main(String[] args) {
        int N = 3;
        int K = 2;
        int[] Arr =new int[] {3,2,1};

        //Approach 1
        System.out.println(kthLargest(N,K,Arr));

        //Approach 2
        System.out.println(kthLargestUsingHeap(N,K,Arr));

    }

    private static int kthLargestUsingHeap(int N, int K, int[] Arr) {

        int size=N*(N+1)/2;
        int[] arr=new int[size];

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=Arr[j];
                pq.offer(sum);
                if(pq.size()>K)
                    pq.poll();
            }
        }
        //O(k)

        return pq.peek();
        //TC:O(n square log k)
        //SC:o(k)
    }

    public static int kthLargest(int N, int K, int[] Arr) {
        int size=N*(N+1)/2;
        int[] arr=new int[size];

        int k=0;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=i;j<N;j++){
                sum+=Arr[j];
                arr[k++]=sum;
            }
        }
        //O(n2)

        Arrays.sort(arr);//(n2logn2)

        return arr[size-K];
        //TC:O(n square log n square)
        //SC:o(n square)
    }
}