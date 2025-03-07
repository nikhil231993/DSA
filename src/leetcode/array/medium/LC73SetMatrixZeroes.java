package leetcode.array.medium;

public class LC73SetMatrixZeroes {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix1 =new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix2 =new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        //Approach 1: Iterate and mark all the 1's in 0's row and column as -1 and then put 0 instead of -1 in other parse
        //TC:O(n*m)(n+m) + O(n*m)
        setZeroesBrute(matrix1);

        for(int[] m:matrix1){
            for(int m1:m){
                System.out.print(m1+" ");
            }
            System.out.println();
        }

        System.out.println("###################");

        //Approach 2: Better
        setZeroes(matrix);

        for(int[] m:matrix){
            for(int m1:m){
                System.out.print(m1+" ");
            }
            System.out.println();
        }

        System.out.println("###################");

        //Approach 3: Optimal
        optimalSetZeroes(matrix2);
        for(int[] n:matrix2){
            for(int n1:n){
                System.out.print(n1 +" ");
            }
            System.out.println();
        }
    }

    private static void optimalSetZeroes(int[][] matrix) {

        int n=matrix.length, m=matrix[0].length;

        //int[] col=new int[n];  matrix[0][..]
        //int[] row=new int[m]; matrix[..][0]

        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;

                    if(j!=0)
                        matrix[0][j]=0;
                    else
                        col0=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0) {

                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        //See if the first row needs to be set to zero as well
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                    matrix[0][j]=0;
            }
        }
        //See if the first column needs to be set to zero as well
        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                    matrix[i][0]=0;
            }
        }

        //TC:O(n*m)+O(n*m)
        //SC:O(1)
    }

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[] col=new int[m];
        int[] row=new int[n];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    col[j]=1;
                    row[i]=1;
                }
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(row[i]==1 || col[j]==1)
                    matrix[i][j]=0;
            }
        }

        //TC:O(n*m)+O(n*m)
        //SC:O(n+m)
    }

    public static void setZeroesBrute(int[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;
        int[][] visited=new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    setMinus(i,j,matrix,m,n, visited);
                }
            }
        }

        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1 && visited[i][j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void setMinus(int row, int col, int[][] matrix,int m,int n, int[][] visited){

        for(int i=0;i<m;i++){
            if( matrix[i][col]!=0){
                matrix[i][col]=-1;
                visited[i][col]=1;
            }
        }
        for(int j=0;j<n;j++){
            if( matrix[row][j]!=0){
                matrix[row][j]=-1;
                visited[row][j]=1;
            }
        }
    }
}
