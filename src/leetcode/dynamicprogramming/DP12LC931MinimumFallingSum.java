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
            min1=Math.min(min1,memoization(n-1,j,n-1,m-1,matrix,dp1));
        }
        System.out.println(min1);

        //Tabulation
        int[][] dp2=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp2[i][j]=-1;
            }
        }
        int min2=Integer.MAX_VALUE;
        tabulation(n,m,matrix,dp2);
        for(int j=0;j<m;j++){
            min2=Math.min(min2,dp2[n-1][j]);
        }
        System.out.println(min2);

        //Space optimization
        int min3=Integer.MAX_VALUE;
       int[] p=space(n,m,matrix);
       for(int i=0;i<p.length;i++)
           min3=Math.min(min3,p[i]);
        System.out.println(min3);

    }

    private static int[] space(int n, int m, int[][] matrix) {
        int[] prev=new int[m];
        for(int j=0;j<m;j++)
            prev[j]=matrix[0][j];

        for(int i=1;i<n;i++){
            int[] current=new int[m];
            for(int j=0;j<m;j++){
                int upper=matrix[i][j]+prev[j];
                int upperLeft=(int)1e9;
                if(j-1>0)
                    upperLeft=matrix[i][j]+prev[j-1];
                int upperRight=(int)1e9;
                if(j+1<m)
                    upperRight=matrix[i][j]+prev[j+1];

                current[j]=Math.min(upper,Math.min(upperLeft,upperRight));
            }
            prev=current;
        }
        return prev;
        //TC:O(N*M)+O(N) last for loop
        //SC:O(n*m) dp array
    }

    private static void tabulation(int n, int m, int[][] matrix, int[][] dp2) {

        for(int j=0;j<m;j++)
            dp2[0][j]=matrix[0][j];

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int upper=matrix[i][j]+dp2[i-1][j];
                int upperLeft=(int)1e9;
                if(j-1>0)
                     upperLeft=matrix[i][j]+dp2[i-1][j-1];
                int upperRight=(int)1e9;
                if(j+1<m)
                  upperRight=matrix[i][j]+dp2[i-1][j+1];

                dp2[i][j]=Math.min(upper,Math.min(upperLeft,upperRight));
            }
        }

        //TC:O(N*M)+O(N) last for loop
        //SC:O(n*m) dp array
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
        //TC:O(N*M)
        //SC:O(N) stack +O(n*m) dp array
    }
}
