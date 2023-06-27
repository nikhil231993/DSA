package leetcode.array.medium;

public class LC73SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix =new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int[][] matrix2 =new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        //Better
        setZeroes(matrix);

        for(int[] m:matrix){
            for(int m1:m){
                System.out.print(m1+" ");
            }
            System.out.println();
        }


        System.out.println("###################");
        //optimal
        optimalSetZeroes(matrix2);
        for(int[] n:matrix2){
            for(int n1:n){
                System.out.print(n1 +" ");
            }
            System.out.println();
        }




    }

    private static void optimalSetZeroes(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        //int[] col=new int[n];  matrix[0][..]
        // int[] row=new int[m]; matrix[..][0]
        int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;

                    if(j!=0)
                        matrix[0][j]=0;
                    else
                        col0=0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=0)
                {
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                    matrix[0][j]=0;
            }
        }

        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                    matrix[i][0]=0;
            }
        }
        //TC:O(n*m)+O(n*m)
        //SC:O(1)
    }

    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] col=new int[n];
        int[] row=new int[m];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    col[i]=1;
                    row[j]=1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[j]==1 || col[i]==1)
                    matrix[i][j]=0;
            }
        }
        //TC:O(n*m)+O(n*m)
        //SC:O(n+m)
    }
}
