package leetcode.array.easy;

public class LC2319MatrixDiagonal {

    public static void main(String[] args) {

        int[][] matrix=new int[][]{{6,0,0,0,0,0,0,18},
                {0,17,0,0,0,0,18,0},
                {0,0,13,0,0,17,0,0},
                {0,0,0,9,18,0,0,0},
                {0,0,0,2,20,0,0,0},
                {0,0,20,0,0,3,0,0},
                {0,14,0,0,0,0,11,0},{19,0,0,0,0,0,0,9}};

        System.out.println(checkXMatrix(matrix));
    }

    public static boolean checkXMatrix(int[][] grid) {

        int n=grid.length;
        boolean countDia=true, countNon=false;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==j || (i+j==(n-1))){
                    if(grid[i][j]==0)
                        countDia=false;
                }else{
                    if(grid[i][j]!=0)
                        countNon=true;
                }
            }
        }
        return countDia==true && countNon==false;

        // TC:O(n * m)
        // SC:O(1)
    }
}
