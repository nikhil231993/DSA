package leetcode.binarysearch;

public class BS25SearchInSortedMatrix2LC240 {

    public static void main(String[] args) {

        int[][] matrix =new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 100;

        //Approach 1
        System.out.println(searchMatrix(matrix,target));

        //Approach 2
        System.out.println(searchMatrixUsingPartialBS(matrix,target));

        //Approach 3
        System.out.println(searchMatrixOptimized(matrix,target));
    }

    private static boolean searchMatrixOptimized(int[][] matrix, int target) {

        int n=matrix.length, m=matrix[0].length;
        int row=0, col=m-1;
        while(row<n && col>=0){
            if(matrix[row][col]==target)
                return true;
            else if(target > matrix[row][col])
                row++;
            else col--;
        }
        return false;

        //TC:O(n+m)
        //SC:O(1)
    }

    public static boolean searchMatrixUsingPartialBS(int[][] matrix, int target) {

        int n=matrix.length, m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1])
                if(binarySearch(matrix[i],n,m,target))
                    return true;
        }
        return false;

        //TC:O(n log m)
        //SC:O(1)
    }

    public static boolean binarySearch(int[] num, int n, int m, int target){

        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==num[mid])
                return true;
            else if(target>num[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;

        //TC:O(n*m)
        //SC:O(1)
    }
}
