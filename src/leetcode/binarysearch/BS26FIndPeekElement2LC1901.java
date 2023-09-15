package leetcode.binarysearch;

public class BS26FIndPeekElement2LC1901 {

    public static void main(String[] args) {
        int[][] mat =new int[][] {{10,20,15},{21,30,14},{7,16,32}};

        //Approach 1
       int[] r1=findPeakGrid(mat);
       System.out.println("Row: "+ r1[0]+" Column: "+r1[1]);

        int[] r2=findPeakGridOptimized(mat);
        System.out.println("Row: "+ r2[0]+" Column: "+r2[1]);

    }

    private static int[] findPeakGridOptimized(int[][] mat) {
        int n=mat.length;;
        int m=mat[0].length;

        int low=0;
        int high=m-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int row=findMax(mat,mid,n,m);
            int left=-1;
            int right=-1;
            if(mid-1 >=0) left=mat[row][mid-1];
            if(mid+1 < m ) right=mat[row][mid+1];

            if(mat[row][mid]> left && mat[row][mid]>right){
                return new int[]{row,mid};
            }else if(mat[row][mid]<left)
                high=mid-1;
            else
                low=mid+1;
        }
        return new int[]{-1,-1};

        //TC:O(log m * n)
    }

    private static int findMax(int[][] num, int col, int n, int m) {
        int max=Integer.MIN_VALUE;
        int maxRowIndex=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(num[i][col]>max)
            {
                max=num[i][col];
                maxRowIndex=i;
            }
        }
        return maxRowIndex;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int left=Integer.MIN_VALUE;
                int right=Integer.MIN_VALUE;
                int top=Integer.MIN_VALUE;
                int bottom=Integer.MIN_VALUE;
                if(j-1>=0)
                    left=mat[i][j-1];
                if(i+1<n)
                    bottom=mat[i+1][j];
                if(i-1>=0)
                    top=mat[i-1][j];
                if(j+1<m)
                    right=mat[i][j+1];
                if(mat[i][j]>left && mat[i][j]> right && mat[i][j]>top && mat[i][j]>bottom)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
        //TC:o(n*m)
        //SC:O(1)
    }

}
