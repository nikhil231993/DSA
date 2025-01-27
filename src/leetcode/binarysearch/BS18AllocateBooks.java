package leetcode.binarysearch;

public class BS18AllocateBooks {

    public static void main(String[] args) {

//      int n=4, m=5;
//      int[] arr=new int[]{12, 34, 67, 90};

        int n=5, m=4;
        int[] arr=new int[]{25, 46, 28, 49, 24};

        //Approach 1: Brute will be TC:O(n square) and we will take each value and check if it can be taken
        System.out.println(findPages(arr,n,m));
    }

    public static int findPages(int[] arr, int n, int m) {

        if(m>n)
            return -1;

        int max=Integer.MIN_VALUE, sum=0;

        for(Integer num: arr){
            max=Math.max(max,num);
            sum+=num;
        }
        int low=max, high=sum, ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(mid, arr, m)){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean possible(int pages, int[] arr ,int m){

        int count=1, sum=arr[0];

        for(int i=1; i<arr.length; i++){
            sum+=arr[i];
            if(sum > pages){
                count++;
                sum=arr[i];
            }
        }
        if(count <= m)
            return true;
        return false;

        // TC:O(log (sum-max+1))* O(n)
        // SC:O(1)
    }
}
