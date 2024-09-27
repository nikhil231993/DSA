package leetcode.binarysearch;

public class BS16KthMissingPositiveNumberLC1539 {

    public static void main(String[] args) {

        int[] arr =new int[] {2,3,4,7,11};
        int k = 5;

        //Approach 1
        System.out.println(findKthPositive(arr,k));

        //Approach 2
        System.out.println(optimizedKthPositive(arr,k));
    }

    private static int optimizedKthPositive(int[] arr, int k) {

        int low=0, high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int missingNumber=arr[mid]-mid-1;

            if(missingNumber<k)
                low=mid+1;
            else
                high=mid-1;
        }

        //arr[high]+more
        //more=K- missingNumber
        //missingNumber=arr[high]-high-1;
        //arr[high]-arr[high]+high+1+k
        return k+high+1;

		// TC: O(log n)
		// SC: O(n)
    }

    public static int findKthPositive(int[] arr, int k) {

        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)
                k++;
            else
                break;
        }
        return k;

        //TC:O(n)
        //SC:O(1)
    }
}
