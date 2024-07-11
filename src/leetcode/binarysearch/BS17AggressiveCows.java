package leetcode.binarysearch;

import java.util.Arrays;

public class BS17AggressiveCows {

    public static void main(String[] args) {

        int n=3,k=2;
        int[] arr=new int[]{1,2,3};
		System.out.println(aggressiveCows(arr, k, n));
    }

	public static int aggressiveCows(int[] stalls, int k, int n) {

        Arrays.sort(stalls);

        int low=1;
        int high=stalls[n-1]-stalls[0];
        int ans=1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPlace(mid, stalls, k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;

		// TC:nlog n +log(arr[n-1]-arr[0])*O(n)
		// SC:O(1)
    }

    public static boolean canPlace(int pos, int[] stalls, int k){

        int count=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last >= pos){
                count++;
                last=stalls[i];
            }
            if(count>=k)
                return true;
        }
        return false;
    }
}
