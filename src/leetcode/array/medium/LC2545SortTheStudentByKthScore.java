package leetcode.array.medium;

import java.util.PriorityQueue;

public class LC2545SortTheStudentByKthScore {
    public static void main(String[] args) {
        int[][] score=new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k = 2;

        //Approach 1
        int[][] result=sortTheStudents(score,k);

        System.out.println("#############");

        for(int i=0;i<score.length;i++){
            for(int j=0;j<score[i].length;j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        int n=score.length;
        int[][] r=new int[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[k]-a[k]);
        for(int[] row:score)
            pq.offer(row);

        int i=0;
        while(!pq.isEmpty())
            r[i++]= pq.poll();
        return r;


        //TC:O(n log n) where n is the row
        //SC:O(n*m) as we store all elements in pq
    }
}
