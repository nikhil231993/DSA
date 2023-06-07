package leetcode.dynamicprogramming;

public class DP43LISUsingBinarySearch {

    public static void main(String[] args) {
        int[] nums =new int[] {1,7,8,4,5,6,-1,9};
        int n=nums.length;

        System.out.println(binarySearch(n,nums));
    }

    private static int binarySearch(int n, int[] nums) {
        int j=0;
        int[] temp=new int[n];
        temp[j]=nums[0];
        int len=1;

        for(int i=1;i<n;i++){
            if(nums[i]>temp[j]){
                temp[++j]=nums[i];
                len++;
            } else{
                int index=0;
                int start=0;
                int end=j;
                while(start<=end){
                    int mid=((end-start)/2)+start;
                    if(temp[mid]==nums[i])
                        temp[mid]=nums[i];
                    else if(nums[i]<temp[mid]){
                        index=mid;
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }
                temp[index]=nums[i];
            }
        }
        System.out.println("Temp array is: ");
        for(int n1:temp)
            System.out.println(n1);
        System.out.println("Length of LIS is: ");
        return len;
        //TC:O(NlogN)
        //SC:O(temp array)
    }
}
