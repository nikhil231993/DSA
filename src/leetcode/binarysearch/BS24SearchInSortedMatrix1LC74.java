package leetcode.binarysearch;

public class BS24SearchInSortedMatrix1LC74 {

    public static void main(String[] args) {

        int[][] matrix =new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 60;

        //Approach 1
        System.out.println(searchMatrix(matrix,target));

        //Approach 2
        System.out.println(searchMatrixUsingPartialBS(matrix,target));

        //Approach 3
        System.out.println(searchMatrixUsingBinarySearch(matrix,target));
    }

    private static boolean searchMatrixUsingBinarySearch(int[][] matrix, int target) {

        int low=0;
        int n=matrix.length, m=matrix[0].length;
        int high=n*m-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(matrix[mid/m][mid%m]==target)
                return true;
            else if(matrix[mid/m][mid%m]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;

        //TC:O(log m*n)
        //SC:O(1)
    }

    private static boolean searchMatrixUsingPartialBS(int[][] matrix, int target) {

        for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0] && target<=matrix[i][matrix[i].length-1])
                return BS(target, matrix[i]);
        }
        return false;

        //TC:O(n)+log m(only once binary search is executed)
        //SC:O(1)
    }

    private static boolean BS(int target, int[] matrix) {

        int low=0, high=matrix.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid]==target)
                return true;
            else if(matrix[mid]>target)
                high=mid-1;
            else
                low=mid+1;
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
