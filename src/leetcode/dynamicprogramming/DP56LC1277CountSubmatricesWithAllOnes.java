package leetcode.dynamicprogramming;

public class DP56LC1277CountSubmatricesWithAllOnes {

    public static void main(String[] args) {
    int[][] matrix =new int[][]
            {{0,1,1,1},
                    {1,1,1,1},
                    {0,1,1,1}};

    int rowLen=matrix.length;
    int colLen=matrix[0].length;

        System.out.println(countSubmtrices(matrix, rowLen,colLen));

        //TC:O(n*m) for loop
        //SC:O(n*m) dp
    }

    private static int countSubmtrices(int[][] matrix, int rowLen, int colLen) {

        int[][] dp=new int[rowLen][colLen];
        //Assign row  and col as the value itself as they themselves will be the ans
        for(int i=0;i<rowLen;i++)
            dp[i][0]=matrix[i][0];
        for(int j=0;j<colLen;j++)
            dp[0][j]=matrix[0][j];
        for(int i=1;i<rowLen;i++){
            for(int j=1;j<colLen;j++){
                if(matrix[i][j]==0)
                    dp[i][j]=0;
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }

        //Calculate the sum to find all the submatrices
        int sum=0;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
