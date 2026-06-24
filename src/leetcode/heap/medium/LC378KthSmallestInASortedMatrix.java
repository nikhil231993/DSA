package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC378KthSmallestInASortedMatrix {

    public static void main(String[] args) {

        int[][] matrix =new int[][] {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        //Approach 1:
        System.out.println(kthSmallest(matrix,k));

        //Approach 2:
        System.out.println(KthSmallestUsingBinarySearch(matrix,k));
    }

    private static int KthSmallestUsingBinarySearch(int[][] matrix,int k) {

        int size=matrix.length, lowest=matrix[0][0], highest=matrix[size-1][size-1];

        while(lowest <= highest){
            int mid=lowest+(highest-lowest)/2;
            int count = countLessOrEqual(mid, matrix, k);
            if(count<k)
                lowest=mid+1;
            else
                highest=mid-1;
        }
        return lowest;
    }

    private static int countLessOrEqual(int mid, int[][] matrix, int k) {

        int col=matrix[0].length-1, row=0, count=0;

        while(col>=0 && row<matrix.length){
            if(matrix[col][row] > mid)
                col--;
            else{
                count=count+col+1;
                row++;
            }
        }
        return count;

        //TC:O(n*log n)
        //SC:O(1)
    }

    private static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)-> b - a);
        int n=matrix.length, m=matrix[0].length;

        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k)
                    pq.poll();
            }
        }
        return pq.peek();

        //TC:O(n square log k)
        //SC:O(k)
    }
}
