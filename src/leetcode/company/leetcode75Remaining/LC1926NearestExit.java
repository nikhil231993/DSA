package leetcode.company.leetcode75Remaining;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row;
    int col;
    int dist;
    public Node(int row, int col, int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}

public class LC1926NearestExit {

    public static void main(String[] args) {
        char[][] maze = new char[][] {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = new int[] {1,2};
        System.out.println(nearestExit(maze, entrance));
    }

    private static int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        int startRow=entrance[0];
        int startCol=entrance[1];

        int[][] visited=new int[m][n];
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol]=1;

        int[] xaxis=new int[]{0,1,0,-1};
        int[] yaxis=new int[]{1,0,-1,0};
        while(!q.isEmpty()){
            Node node=q.poll();
            int r=node.row;
            int c=node.col;
            int dist=node.dist;

            for(int k=0;k<4;k++){
                int xnew=r+xaxis[k];
                int ynew=c+yaxis[k];

                if(xnew>=0 && ynew>=0 && xnew<m && ynew<n && visited[xnew][ynew]==0 && maze[xnew][ynew]=='.'){
                    if (xnew == 0 || ynew == 0 || xnew == m - 1 || ynew == n - 1)
                        return dist + 1;
                    visited[xnew][ynew]=1;
                    q.offer(new Node(xnew, ynew, dist+1));
                }
            }
        }
        return -1;
    }
}
