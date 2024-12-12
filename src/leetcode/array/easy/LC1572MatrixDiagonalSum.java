package leetcode.array.easy;

public class LC1572MatrixDiagonalSum {

    public static void main(String[] args) {

        int[][] mat =new int[][] {{1,2,3},
                {4,5,6},
                {7,8,9}};

        //Approach 1
        System.out.println(diagonalSum(mat));

        //Approach 2
        System.out.println(diagonalSumOptimal(mat));
    }

    private static int diagonalSumOptimal(int[][] mat) {

        int n=mat.length, sum=0, mid=n/2;

        for(int i=0; i<mat.length; i++){
            sum+=mat[i][i]+mat[i][n-1-i];
        }
        if(n%2 ==1)
            return sum-mat[mid][mid];
        return sum;

        //TC:O(n)
        //SC:O(1)
    }

    public static int diagonalSum(int[][] mat) {

        int n=mat.length, sum=0;

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(i==j || (i+j==(n-1))){
                    sum+=mat[i][j];
                }
            }
        }

        return sum;

        //TC:O(n*m)
        //SC:O(1)
    }
}
