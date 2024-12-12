package leetcode.array.medium;

import java.util.PriorityQueue;

class Node2{

    protected int value;
    protected int row;

    public Node2(int value, int row){
        this.value=value;
        this.row=row;
    }
}

public class LC2545SortTheStudentByKthScore {

    public static void main(String[] args) {

        int[][] score=new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k = 2;

        //Approach 1
        int[][] result = sortTheStudents(score,k);

        for(int i=0;i<score.length;i++){
            for(int j=0;j<score[i].length;j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

        System.out.println("#############");

        //Approach 2
        int[][] score1=new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int[][] result1 = sortTheStudentsOptimal(score1,k);

        for(int i=0;i<score.length;i++){
            for(int j=0;j<score[i].length;j++){
                System.out.print(result1[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] sortTheStudents(int[][] score, int k) {

        int n=score.length;
        int[][] r=new int[n][n];

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[k] - a[k]);
        for(int i=0; i<n; i++)
            pq.offer(score[i]);

        int i=0;
        while(!pq.isEmpty())
            r[i++]= pq.poll();
        return r;

        //TC:O(n log n) where n is the row
        //SC:O(n*m) as we store all elements in pq
    }

    public static int[][] sortTheStudentsOptimal(int[][] score, int k) {

        int n=score.length;
        int m=score[0].length;

        PriorityQueue<Node2> pq=new PriorityQueue<>((a,b)->b.value - a.value);

        for(int i=0; i<n; i++){
            pq.offer(new Node2(score[i][k], i));
        }

        int[][] result=new int[n][m];
        int i=0;
        while(!pq.isEmpty()){
            result[i++]=score[pq.poll().row];

        }
        return result;
    }
}
