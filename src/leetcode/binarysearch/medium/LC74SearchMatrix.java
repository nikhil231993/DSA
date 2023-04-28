package leetcode.binarysearch.medium;

public class LC74SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(search(matrix,13));
    }

    private static boolean search(int[][] matrix,int target) {

        int row=matrix.length;
        int column=matrix[0].length;
        int start=0;
        int end=row*column-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[mid/column][mid%column]==target){
                return true;
            }else if(matrix[mid/column][mid%column]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return false;
    }
}
