package leetcode.graph;

import java.util.Arrays;

public class G42FloydWarshall {

    public static void main(String[] args) {
      int[][]  matrix = new int[][]{{0,1,43},{1,0,6},{-1,-1,0}};

      shortest_distance(matrix);

      //TC:O(N cube)
        //SC:O(N cube) since we are using input matrix to change the value

      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              System.out.print(matrix[i][j]+"       ");
          }
          System.out.println();
      }
    }
    public static void shortest_distance(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if(i==j){
                    matrix[i][j]=0;
                }
            }
        }

        int n=matrix.length;

        for(int k=0;k<n;k++){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++) {
                        matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[i][i]<0){
                System.out.println("Cycle is present");
            }
        }

        //resetting matrix back
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
