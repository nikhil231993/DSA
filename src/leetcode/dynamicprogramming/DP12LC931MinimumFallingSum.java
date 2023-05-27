package leetcode.dynamicprogramming;

public class DP12LC931MinimumFallingSum {

    public static void main(String[] args) {
       int[][] matrix =new int[][] {{2,1,3},{6,5,4},{7,8,9}};

       //Recursion
        int n=matrix.length;
        int m=matrix[0].length;

        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,recursion(n-1,j,n-1,m-1,matrix));
        }
        System.out.println(min);

        //Memoization
        int[][] dp1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp1[i][j]=-1;
            }
        }
        int min1=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min1=Math.min(min,memoization(n-1,j,n-1,m-1,matrix,dp1));
        }
        System.out.println(min1);

    }

    public static int recursion(int i, int j, int n, int m, int[][] matrix){
        if(j<0 || j>m)
            return (int)1e9;
        if(i==0)
            return matrix[0][j];

        int upper=matrix[i][j]+recursion(i-1,j,n,m,matrix);
        int upperLeft=matrix[i][j]+recursion(i-1,j-1,n,m,matrix);
        int upperRight=matrix[i][j]+recursion(i-1,j+1,n,m,matrix);

        return Math.min(upper,Math.min(upperLeft,upperRight));
        //TC:O(3 raise to n)
        //SC:O(N)
    }

    public static int memoization(int i, int j, int n, int m, int[][] matrix,int[][] dp1){
        if(j<0 || j>m)
            return (int)1e9;
        if(i==0)
            return matrix[0][j];
        if(dp1[i][j]!=-1)
            return dp1[i][j];

        int upper=matrix[i][j]+memoization(i-1,j,n,m,matrix,dp1);
        int upperLeft=matrix[i][j]+memoization(i-1,j-1,n,m,matrix,dp1);
        int upperRight=matrix[i][j]+memoization(i-1,j+1,n,m,matrix,dp1);

        return dp1[i][j]=Math.min(upper,Math.min(upperLeft,upperRight));
        //TC:O(N)
        //SC:O(N) stack +O(n*m) dp array
    }
}
