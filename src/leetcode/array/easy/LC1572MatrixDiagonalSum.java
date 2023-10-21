package leetcode.array.easy;

public class LC1572MatrixDiagonalSum {

    public static void main(String[] args) {
        int[][] mat =new int[][] {{1,2,3},
                {4,5,6},
                {7,8,9}};
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {

        int n=mat.length;
        int mid=n/2;
        int sum=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==j || (i+j==(n-1))){
                    sum+=mat[i][j];
                }
            }
        }
        return sum;

    }
}
