package leetcode.binarysearch;

public class BS27MedianInRowWiseSortedArray {

    public static void main(String[] args) {
        int R = 3, C = 3;
        int[][] M =new int[][] {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(median(M,R,C));
    }
    public static int median(int matrix[][], int R, int C) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<R;i++){
            low=Math.min(matrix[i][0],low);
            high=Math.max(matrix[i][C-1],high);
        }
        int ans=-1;
        int required=R*C/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int no=find(matrix, mid, R, C);
            if(no<=required){
                ans =mid;
                low=mid+1;
            }else
                high=mid-1;
        }
        return ans;
    }

    public static int find(int[][] matrix, int mid, int R, int C){
        int count=0;
        for(int i=0;i<R;i++){
            count+=upperBound(matrix[i], mid);
        }
        return count;
    }

    public static int upperBound(int[] num, int target){
        int low=0;
        int high=num.length-1;
        int ans=num.length;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(num[mid] >= target){
                ans= mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        //TC:log(max-min)*R *log C
    }
}
