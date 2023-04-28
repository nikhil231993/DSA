package leetcode.binarysearch.medium;

public class LC33SeacrhInRotatedSortedArray {

    public static void main(String[] args) {
        int[] num=new int[]{4,5,6,7,0,1,2};
        int target=2;
        System.out.println(search(num,target));
    }

    private static int search(int[] num,int target) {

        int low=0;
        int high=num.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(num[mid]==target)
                return mid;
            else if(num[low]<=num[mid]){
                if(target >=num[low] && target <=num[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target >=num[mid] && target <=num[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
