package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class G9LC733FloodFill {

    public static void main(String[] args) {
        int[][] image=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int oldColor=image[sr][sc];
        int n=image.length;
        int m=image[0].length;
        int[][] ans=image;

       //Creating 4 directions for DFS traversal;
        int[] x_axis=new int[]{1,0,-1,0};
        int[] y_axis=new int[]{0,-1,0,1};


        dfsTraversal(image,ans,n,m,oldColor,sr,sc,color,x_axis,y_axis);

        System.out.println("Using dfs");

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }

        System.out.println("Using bfs");

        //By using BFS
        int[][] ans_bfs=image;
        bfs(image,ans,sr,sc,color,oldColor,x_axis,y_axis,n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
        System.out.println("Using recursion");
        //By using Recursion
        recursion(image, oldColor, n, m, sr, sc, color);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs(int[][] image, int[][] ans, int sr, int sc, int color, int oldColor, int[] xAxis, int[] yAxis, int n, int m) {
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(sr,sc));

    ans[sr][sc]=color;

    while(!q.isEmpty()){

        int first=q.peek().first;
        int second=q.peek().second;
        for(int i=0;i<4;i++) {
            int new_row = first + xAxis[i];
            int new_col = second + yAxis[i];
            q.poll();
            if(new_col>=0 && new_col<m && new_row>=0 && new_row<n && image[new_row][new_col]==oldColor && ans[new_row][new_col]!=color) {
                ans[new_row][new_col]=color;
            q.offer(new Pair(new_row,new_col));
            }
            }
        }
    }




    private static void dfsTraversal(int[][] image, int[][] ans, int n, int m, int oldColor, int sr, int sc, int color, int[] xAxis, int[] yAxis) {

        ans[sr][sc]=color;

    for(int i=0;i<4;i++){
        int new_row=sr+xAxis[i];
        int new_col=sc+yAxis[i];

        if(new_col>=0 && new_col<m && new_row>=0 && new_row<n && image[new_row][new_col]==oldColor && ans[new_row][new_col]!=color){
            dfsTraversal(image,ans,n,m,oldColor,new_row,new_col,color,xAxis,yAxis);
        }
    }

        //SC:O(m*n) recursive stack where all elements are stored in stack +O(M*N) ans matrix
        //TC:o(m*n*4) where 4 neighbours where 4 can be avoided


    }


    private static void recursion(int[][] image, int oldColor, int n, int m,int sr, int sc,int newColor) {

        if(sr<0 || sr>=n||sc<0||sc>=m||image[sr][sc]!=oldColor)
            return;
        image[sr][sc]=newColor;
        recursion(image,oldColor,n,m,sr+1,sc,newColor);
        recursion(image,oldColor,n,m,sr-1,sc,newColor);
        recursion(image,oldColor,n,m,sr,sc+1,newColor);
        recursion(image,oldColor,n,m,sr,sc-1,newColor);
        //SC:O(m*n)
        //TC:O(m*n)
    }
}
