package leetcode.binarysearch;

public class BS27MedianInRowWiseSortedArrayLCPremium {

    public static void main(String[] args) {

        int R = 3, C = 5;
//        int[][] M =new int[][] {{1, 5 ,7,9,11},
//                {2,3,4,8,9},
//                {4,11,14,19,20},
//                {6,10,22,99,100},
//                {4,15,17,24,28}
//        };

        int[][] M=new int[][]{{1,5,7,10,11},{2,3,4,5,10},{10,10,12,14,16}};

//        int[][] M =new int[][] {{1, 2 ,3},
//                {3,3,3},
//                {3,3,9}
//        };
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
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
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

             if(num[mid]>target){
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
